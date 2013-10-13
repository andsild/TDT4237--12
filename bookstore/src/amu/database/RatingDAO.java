package amu.database;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.util.logging.Level;

import amu.model.Customer;
import amu.model.Rating;

public class RatingDAO
{
	 public Rating register(Rating rRating) 
	 {
        DataSource dataSource = null;
        Connection connection = null;
        Statement statement = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            String query = "INSERT INTO rating (ID, fk_customerID, fk_bookID, ratevalue) VALUES ("
                    + "NULL"
                    + ", "
                    + Integer.toString(rRating.getCustomer().getId())
                    + ", "
                    + Integer.toString(rRating.getBookID())
                    + ", "
                    + rRating.getRating()
                    + ")";
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
	 
	 public Integer getAverageRating(Integer iBookID) throws Exception
	 {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        Integer retInt = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            //XXX: not validet input 
            String query = "SELECT AVG(ratevalue) AS average FROM rating WHERE fk_bookID = "
            		+ Integer.toString(iBookID)
            		+ " GROUP BY fk_bookID;";
            resultSet = statement.executeQuery(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findById SQL Query: " + query);
            if (resultSet.next())
            {
            	float fAvg = resultSet.getFloat("average");
            	retInt = (int) fAvg;
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
	 
	 public Rating findByIDS(Integer iCustomerID, Integer iBookID)
	 {
		Rating rRating = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            //XXX: not validet input 
            String query = "SELECT * FROM rating WHERE rating.fk_customerID="
                    + Integer.toString(iCustomerID)
                    + " AND rating.fk_bookID="
                    + Integer.toString(iBookID)
                    + ";";
            resultSet = statement.executeQuery(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findById SQL Query: " + query);


            if (resultSet.next()) {
            	int iRateId = resultSet.getInt("ID");
            	int iCustId = resultSet.getInt("fk_customerID");
            	String sRating = resultSet.getString("ratevalue");
            	
            	//FIXME: fill me in PROPERLY
            	rRating = new Rating(iRateId, new CustomerDAO().findByEmail("HEY"), sRating, iBookID);
            }
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        return rRating;
	 }
	 
	 public Rating findByID(int iId)
	 {
		Rating rRating = null;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();

            //TODO: fill me in 
            String query = "SELECT * FROM rating WHERE ID="
                    + iId
                    + ";";
            resultSet = statement.executeQuery(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findById SQL Query: " + query);


            if (resultSet.next()) {
            	int iRateId = resultSet.getInt("ID");
            	int iCustId = resultSet.getInt("fk_customerID");
            	int iBookID = resultSet.getInt("fk_bookID");
            	String sRating = resultSet.getString("ratevalue");
            	
            	//FIXME: fill me in PROPERLY
            	rRating = new Rating(iRateId, new CustomerDAO().findByEmail("HEY"), sRating, iBookID);
            }
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        return rRating;
	 }
	 
}

/* EOF */