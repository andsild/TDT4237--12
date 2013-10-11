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

            //TODO: fill me in
            String query = "INSERT INTO <RATING> (ID, CUSTOMERID, BOOKID, RATEVALUE) VALUES ('"
            		/*
                    + customer.getEmail()
                    + "', '"
                    + customer.getPassword()
                    + "', '"
                    + customer.getName()
                    + "', '"
                    + customer.getActivationToken()
                    + "')";
                    */;
            statement.executeUpdate(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "register SQL Query: " + query);

        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement);
        }

        return findByID(rRating.getId());
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
            String query = "SELECT * FROM <RATING> WHERE ID='"
                    + iId
                    + "'";
            resultSet = statement.executeQuery(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findById SQL Query: " + query);


            if (resultSet.next()) {
            	int iRateId = resultSet.getInt("id");
            	int iCustId = resultSet.getInt("...");
            	
            	//TODO: fill me in
            	//rRating = new Rating(ku, iRateValue, iBookID)
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