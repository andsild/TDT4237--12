package amu.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelpfulDAO
{
	 public void register(String sCustomerID, String sReviewID, String sHelpfulInteger) 
	 {
        Connection connection = null;
        java.sql.PreparedStatement statement = null;
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
	                    + "? , ? , 1, 0);";
	            }
        	else if (sHelpfulInteger.equals("0"))
        	{
        		sQuery= "INSERT INTO helpful (fk_reviewID, fk_customerID, thumbUP, thumbDOWN) VALUES ("
	                    + " ? , ? , 0, 1);";
	        }
        	else { throw new RuntimeException("invalid data"); }
        }
        try {
            connection = Database.getConnection();
            statement = connection.prepareStatement(sQuery);
            
            statement.setInt(1,  Integer.parseInt(sReviewID));
            statement.setInt(2,  Integer.parseInt(sCustomerID));
            
            statement.executeUpdate();
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
	     java.sql.PreparedStatement statement = null;
	     ResultSet resultSet = null;
	        
	        try {
	            connection = Database.getConnection();
	            
	            String query = "SELECT fk_customerID, fk_reviewID FROM helpful"
	            		+ " WHERE fk_customerID = ? AND fk_reviewID = ?";
	            statement = connection.prepareStatement(query);

	            statement.setInt(1,  Integer.parseInt(sReviewID));
	            statement.setInt(2,  Integer.parseInt(sCustomerID));

	            resultSet = statement.executeQuery();
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