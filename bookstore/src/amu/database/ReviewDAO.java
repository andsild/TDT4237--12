package amu.database;

import java.sql.Connection;
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
	 public Review register(Review rReview) 
	 {
        Connection connection = null;
        Statement statement = null;
        
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            
            //FIXME: need a db lock to avoid race condtions
            
            String query = "INSERT INTO review (ID, fk_customerID, fk_bookID, text) VALUES ("
                    + "NULL"
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

        //FIXME: get back the value of the ID
        return null;
	 }
	public ArrayList<HelpfulReview> getReviews(String sBookID) 
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		ArrayList<HelpfulReview> alHelpful = new ArrayList<HelpfulReview>();

		try {
			connection = Database.getConnection();
			statement = connection.createStatement();

			String sQuery = "SELECT R.id, R.text, SUM(COALESCE(H.thumbsUp, 0)) AS thumbsUp, SUM(COALESCE(H.thumbsDown, 0)) AS thumbsDown "
					+ "FROM review AS R  "
					+ "LEFT JOIN (SELECT fk_reviewID AS fkr, SUM(COALESCE(thumbUp,0)) AS thumbsUp, SUM(COALESCE(thumbDown,0)) AS thumbsDown "
					+ "FROM helpful GROUP BY fkr ) AS H ON H.fkr=R.id WHERE "
					+ "fk_bookID = "
					+ sBookID
					+ " GROUP BY H.fkr";
			resultSet = statement.executeQuery(sQuery);

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