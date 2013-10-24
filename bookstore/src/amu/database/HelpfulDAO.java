package amu.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelpfulDAO
{
	 public void register(String sCustomerID, String sReviewID, String sHelpfulInteger) 
	 {
        Connection connection = null;
        Statement statement = null;
        String sQuery = "";
        
        if (thumbExist(sCustomerID, sReviewID))
        {
        	return;
        }
        
        else
        {
        	if(sHelpfulInteger.equals("1"))
	            {           
	            	sQuery= "INSERT INTO helpful (fk_reviewID, fk_customerID, thumbUP, thumbDOWN) VALUES ("
	                    + "\"" + sReviewID + "\""
	                    + ", "
	                    + sCustomerID
	                    + ", "
	                    + "1, 0"
	                    + ");";
	            }
        	else
        	{
        		sQuery= "INSERT INTO helpful (fk_reviewID, fk_customerID, thumbUP, thumbDOWN) VALUES ("
	                    + "\"" + sReviewID + "\""
	                    + ", "
	                    + sCustomerID
	                    + ", "
	                    + "0, 1" 
	                    + ");";
	        }
        }
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            statement.executeUpdate(sQuery);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "register SQL Query: " + sQuery);
            
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement);
        }
	 }
	 
	 public boolean thumbExist(String sCustomerID, String sReviewID)
	 {
		 Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;
	        
	        try {
	            connection = Database.getConnection();
	            statement = connection.createStatement();
	            
	            String query = "SELECT fk_customerID, fk_reviewID FROM helpful"
	            		+ " WHERE fk_customerID = "
	            		+ sCustomerID 
	            		+ " AND fk_reviewID = "
	            		+ sReviewID + ";";

	            resultSet = statement.executeQuery(query);
	            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findByISBN SQL Query: " + query);
	            return (resultSet.next() == true);
	        }
	        catch (SQLException exception) {
	            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
	        } finally {
	            Database.close(connection, statement, resultSet);
	        }
	        return false;
	 }
}

/* EOF */