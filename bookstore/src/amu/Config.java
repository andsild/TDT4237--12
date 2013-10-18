package amu;

public class Config {
    public final static String JDBC_RESOURCE = "jdbc/bookstore";
    
    public final static String EMAIL_SMTP_HOST = "smtp.gmail.com";
    public final static String EMAIL_SMTP_PORT = "587";
    public final static String EMAIL_SMTP_USER = "tdt4237.amu.darya";
    public final static String EMAIL_SMTP_PASSWORD = "jcmrgkikcdqoyjms"; // Application-specific password
    
    public final static String EMAIL_FROM_ADDR = "tdt4237.amu.darya@gmail.com";
    public final static String EMAIL_FROM_NAME = "Amu-Darya";
    public final static String EMAIL_TECH = "tdt4237.amu.darya@gmail.com";
    public final static String EMAIL_SALES = "tdt4237.amu.darya@gmail.com"; 
    
    public final static String SALT="NaCl"; // Changing this will invalidate all customer passwords in DB
    
    public final static FilterUnit VALIDATE_EMAIL			 		= FilterUnit.getMailValidator(); 
    public final static FilterUnit VALIDATE_PASSWORD 				= FilterUnit.getPasswordValidator();
    public final static FilterUnit VALIDATE_TEXT_AND_NUMBERS 		= FilterUnit.getTextAndNumberValidator();
    public final static FilterUnit VALIDATE_TEXT 	 				= FilterUnit.getTextValidator(); 
    
    
}
