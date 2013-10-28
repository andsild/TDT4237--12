package amu;

import java.security.Security;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import amu.database.Database;

import com.sun.mail.smtp.SMTPTransport;

public class Mailer {
	
	private final static String username="tdt4237.gruppe12",
						   password="asciipenis";
	public static void send(String to, String subject, String content) {
		try {
			Mailer.send(to, subject, content, Config.EMAIL_FROM_ADDR, Config.EMAIL_FROM_NAME);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

    public static void send(String to, String subject, String content, String fromAddr, String fromName) throws AddressException, MessagingException 
    {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");
        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        final MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(Mailer.username + "@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
        msg.setSubject(subject);
        msg.setText(content, "utf-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

        t.connect("smtp.gmail.com", username, password);
        t.sendMessage(msg, msg.getAllRecipients());      
        
        Mailer.log(to,  subject, content);
        
        t.close();
    }

	private static void log(String to, String subject, String content) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = Database.getConnection("email");
			String query = "INSERT INTO mail (sentTime, `to`, `subject`, content) VALUES (NOW(), ?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setString(1, to);
			statement.setString(2, subject);
			statement.setString(3, content);
			statement.executeUpdate();
		} catch (SQLException exception) {
			Logger.getLogger(Mailer.class.getName()).log(Level.SEVERE, null, exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}
	}
}
