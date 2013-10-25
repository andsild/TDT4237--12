package amu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import amu.model.Rating;

public class RatingDAO
{
	 public void register(Rating rRating) 
	 {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = Database.getConnection();

            String query = "INSERT INTO rating (ID, fk_customerID, fk_bookID, ratevalue) VALUES ("
                    + "NULL, ? , ? , ?)";
            statement = connection.prepareStatement(query);
            
            statement.setInt(1,  rRating.getCustomer().getId());
            statement.setInt(2,  rRating.getBookID());
            statement.setInt(3,  Integer.parseInt(rRating.getRating()));
            
            statement.executeUpdate();
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "register SQL Query: " + query);
            
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement);
        }
	 }
	 
	 public Integer getAverageRating(Integer iBookID) throws Exception
	 {
        Connection connection = null;
        PreparedStatement statement = null;

        ResultSet resultSet = null;
        
        Integer retInt = null;

        try {
            connection = Database.getConnection();

            String query = "SELECT AVG(ratevalue) AS average FROM rating WHERE fk_bookID = ? "
            		+ " GROUP BY fk_bookID;";
            
            statement = connection.prepareStatement(query);
            statement.setInt(1, iBookID);
            resultSet = statement.executeQuery();

            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findById SQL Query: " + query);
            try
            {
	            if (resultSet.next())
	            {
	            	float fAvg = resultSet.getFloat("average");
	            	retInt = (int) fAvg;
	            }
	            
	            if(retInt == null || retInt < 0 || retInt > 6) 
				{
					throw new RuntimeException("rating: bad values");
				}
            }
	            
	            catch(Exception e)
	            {
	            	return 3;
	            }
        }
        catch (SQLException exception) {
            	Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        }

         finally 
        {
            Database.close(connection, statement, resultSet);
        }

        return retInt;
	 }
	 
	 public Integer getRating(Integer iCustomerID, Integer iBookID)
	 {
		Integer iRating = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            String query = "SELECT * FROM rating WHERE rating.fk_customerID= ? "
                    + " AND rating.fk_bookID= ? ";

            statement = connection.prepareStatement(query);
            
            statement.setInt(1,  iCustomerID);
            statement.setInt(2,  iBookID);

            resultSet = statement.executeQuery();
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findById SQL Query: " + query);


            if (resultSet.next()) {
            	iRating = resultSet.getInt("ratevalue");
            }
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        return iRating;
	 }
}

/* EOF */