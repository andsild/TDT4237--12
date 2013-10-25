package amu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import amu.model.HelpfulReview;
import amu.model.Review;

public class ReviewDAO
{
	 public void register(Review rReview) 
	 {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = Database.getConnection();
            
            String query = "INSERT INTO review (ID, fk_customerID, fk_bookID, text) VALUES ("
                    + "NULL, ? , ? , ? )";
            statement = connection.prepareStatement(query);
            
            statement.setInt(1,  rReview.getCustomer().getId());
            statement.setInt(2,  rReview.getBookID());
            statement.setString(3, rReview.getReview());
            statement.executeUpdate();
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "register SQL Query: " + query);
            
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement);
        }
	 }
	public ArrayList<HelpfulReview> getReviews(String sBookID) 
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		ArrayList<HelpfulReview> alHelpful = new ArrayList<HelpfulReview>();

		try {
			connection = Database.getConnection();

			String sQuery = "SELECT R.id, R.text, SUM(COALESCE(H.thumbsUp, 0)) AS thumbsUp, SUM(COALESCE(H.thumbsDown, 0)) AS thumbsDown "
					+ "FROM review AS R  "
					+ "LEFT JOIN (SELECT fk_reviewID AS fkr, SUM(COALESCE(thumbUp,0)) AS thumbsUp, SUM(COALESCE(thumbDown,0)) AS thumbsDown "
					+ "FROM helpful GROUP BY fkr ) AS H ON H.fkr=R.id WHERE "
					+ "fk_bookID = ? GROUP BY H.fkr";
			statement = connection.prepareStatement(sQuery);
			statement.setInt(1,  Integer.parseInt(sBookID));
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int iReviewID = resultSet.getInt("id");
				int iThumbsUp = resultSet.getInt("thumbsUp"), 
					iThumbsDown = resultSet.getInt("thumbsDown");
				String sText = resultSet.getString("text");
				
				alHelpful.add(new HelpfulReview(iReviewID, sText, iThumbsUp, iThumbsDown));
			}
		} catch (SQLException ex) {
			System.out.println("SQLException in page: " + ex.getMessage());
		} finally {
			Database.close(connection, statement, resultSet);
		}
		
		return alHelpful;
	 }
}

/* EOF */