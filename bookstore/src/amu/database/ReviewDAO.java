package amu.database;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;

import amu.model.Book;
import amu.model.Customer;
import amu.model.Review;
import amu.model.Review;

public class ReviewDAO
{
	 public Review register(Review rReview) 
	 {
		 //TODO: also register helpful
        DataSource dataSource = null;
        Connection connection = null;
        Statement statement = null;
        
        String sMaxID = getMaxID();

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            
            //FIXME: need a db lock to avoid race condtions
            
            String query = "INSERT INTO review (ID, fk_customerID, fk_bookID, text) VALUES ("
                    + sMaxID
                    + ", "
                    + Integer.toString(rReview.getCustomer().getId())
                    + ", "
                    + Integer.toString(rReview.getBookID())
                    + ", \""
                    + rReview.getReview()
                    + "\" );";
            statement.executeUpdate(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "register SQL Query: " + query);
            
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement);
        }
        
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            
            //FIXME: need a db lock to avoid race condtions
            
            String query= "INSERT INTO helpful (fk_reviewID, fk_customerID, thumbUP, thumbDOWN) VALUES ("
                    + "\"" + sMaxID + "\""
                    + ", "
                    + Integer.toString(rReview.getCustomer().getId())
                    + ", "
                    + "0, 0"
                    + ");";
            statement.executeUpdate(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "register SQL Query: " + query);
            
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement);
        }

        //FIXME: get back the value of the ID
        return null;
	 }
	 
	 private String getMaxID()
	 {
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;
	        
	        try {
	            connection = Database.getConnection();
	            statement = connection.createStatement();
	            
	            String query = "SELECT MAX(id) AS maxid FROM review";

	            resultSet = statement.executeQuery(query);
	            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findByISBN SQL Query: " + query);
	            
	            if (resultSet.next()) {
	            	int iRetId = resultSet.getInt("maxid") + 1;
	            	return Integer.toString(iRetId);
	            }
	        }
	        catch (SQLException exception) {
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
	        } finally {
	            Database.close(connection, statement, resultSet);
	        }
	        
	        return null;
	 }
}

/* EOF */