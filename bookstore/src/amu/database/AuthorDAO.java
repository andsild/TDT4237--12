package amu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import amu.model.Author;

public class AuthorDAO {
    public List<Author> findByBookID(int bookID) {
        List<Author> authors = new ArrayList<Author>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = Database.getConnection();
            String query = "SELECT "
                    + "author.id, "
                    + "author.name "
                    + "FROM author, author_x_book "
                    + "WHERE author_x_book.book_id= ? "
                    + "AND author.id = author_x_book.author_id";
            statement = connection.prepareStatement(query);
            statement.setInt(1,  bookID);
            resultSet = statement.executeQuery();
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findByBookID SQL Query: " + query);
            
            while (resultSet.next()) {
                authors.add(new Author(resultSet.getInt("author.id"), resultSet.getString("author.name")));
            }
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        
        return authors;
    }
}
