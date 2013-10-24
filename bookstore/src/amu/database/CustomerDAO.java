package amu.database;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.DatatypeConverter;

import amu.BCrypt;
import amu.model.Customer;

public class CustomerDAO {

    public static String hashPassword(String plainTextPassword) {
        /*
    	String hashedPassword = null;
        try {
            // Calculate SHA1(password+salt)
            hashedPassword = DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA1").digest((plainTextPassword + Config.SALT).getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hashedPassword;
        */
    	return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static String generateActivationCode() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[8];
        random.nextBytes(bytes);
        return DatatypeConverter.printHexBinary(bytes);
    }

    public Customer findByEmail(String email) {
        Customer customer = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            String query = "SELECT * FROM customer WHERE email='"
                    + email
                    + "'";
            resultSet = statement.executeQuery(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findByEmail SQL Query: " + query);


            if (resultSet.next()) {
                customer = new Customer();
                customer.setId(resultSet.getInt("id"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                customer.setName(resultSet.getString("name"));
                customer.setActivationToken(resultSet.getString("activation_token"));
            }
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        return customer;
    }

    public boolean edit(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();

            String query = "UPDATE customer SET email=?, password=?, name=? WHERE id=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, customer.getEmail());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setInt(4, customer.getId());
          
            if (statement.executeUpdate() == 0) {
                return false; // No rows were affected
            } else {
                return true;
            }

        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
            return false;
        } finally {
            Database.close(connection, statement, resultSet);
        }
    }
    
    public Customer register(Customer customer) {

        Connection connection = null;
        Statement statement = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            String query = "INSERT INTO customer (email, password, name, activation_token) VALUES ('"
                    + customer.getEmail()
                    + "', '"
                    + customer.getPassword()
                    + "', '"
                    + customer.getName()
                    + "', '"
                    + customer.getActivationToken()
                    + "')";
            statement.executeUpdate(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "register SQL Query: " + query);

        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement);
        }

        return findByEmail(customer.getEmail());
    }

    public Customer activate(Customer customer) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            String query = "UPDATE customer SET activation_token=NULL WHERE email='"
                    + customer.getEmail()
                    + "'";
            statement.executeUpdate(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "activate SQL Query: " + query);

            customer.setActivationToken(null);

        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        return customer;
    }
    
}