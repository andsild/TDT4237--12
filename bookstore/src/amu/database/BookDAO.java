package amu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import amu.model.Book;
import amu.model.Publisher;
import amu.model.Title;

public class BookDAO {
    public Book findByISBN(String isbn) {
        Book book = null;
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            
            String query = "SELECT * FROM book, publisher, title "
                    + "WHERE book.isbn13 = '"
                    + isbn + "' "
                    + "AND book.title_id = title.id "
                    + "AND book.publisher_id = publisher.id;";
            resultSet = statement.executeQuery(query);
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findByISBN SQL Query: " + query);
            
            if (resultSet.next()) {
                AuthorDAO authorDAO = new AuthorDAO(); // TODO:
                
                book = new Book();
                book.setId(resultSet.getInt("book.id"));
                book.setTitle(new Title(resultSet.getInt("title.id"), resultSet.getString("title.name")));
                book.setPublisher(new Publisher(resultSet.getInt("publisher.id"), resultSet.getString("publisher.name")));
                book.setPublished(resultSet.getString("book.published"));
                book.setEdition(resultSet.getInt("book.edition"));
                book.setBinding(resultSet.getString("book.binding"));
                book.setIsbn10(resultSet.getString("book.isbn10"));
                book.setIsbn13(resultSet.getString("book.isbn13"));
                book.setDescription(resultSet.getString("book.description"));
                book.setAuthor(authorDAO.findByBookID(resultSet.getInt("book.id")));
                book.setPrice(resultSet.getFloat("book.price"));
                // TODO: Reviews, Categories
            }
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        
        return book;
    }
    public Book findByID(String ID) {
        Book book = null;
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
        	connection = Database.getConnection();
            statement = connection.createStatement();
            
            String query = "SELECT * FROM book, publisher, title "
                    + "WHERE book.id = '"
                    + ID + "' "
                    + "AND book.title_id = title.id "
                    + "AND book.publisher_id = publisher.id;";
            resultSet = statement.executeQuery(query);
            
            Logger.getLogger(this.getClass().getName()).log(Level.FINE, "findByISBN SQL Query: " + query);
            
            if (resultSet.next()) {
                AuthorDAO authorDAO = new AuthorDAO(); // TODO:
                
                book = new Book();
                book.setId(resultSet.getInt("book.id"));
                book.setTitle(new Title(resultSet.getInt("title.id"), resultSet.getString("title.name")));
                book.setPublisher(new Publisher(resultSet.getInt("publisher.id"), resultSet.getString("publisher.name")));
                book.setPublished(resultSet.getString("book.published"));
                book.setEdition(resultSet.getInt("book.edition"));
                book.setBinding(resultSet.getString("book.binding"));
                book.setIsbn10(resultSet.getString("book.isbn10"));
                book.setIsbn13(resultSet.getString("book.isbn13"));
                book.setDescription(resultSet.getString("book.description"));
                book.setAuthor(authorDAO.findByBookID(resultSet.getInt("book.id")));
                book.setPrice(resultSet.getFloat("book.price"));
                // TODO: Reviews, Categories
                
            }
        } catch (SQLException exception) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
        } finally {
            Database.close(connection, statement, resultSet);
        }
        
        return book;
    }
    public Map<String, String> getListBooks(){
    	Map<String, String> map = new HashMap<String, String>();
    	Connection connection = null;
    	PreparedStatement  statement = null;
    	ResultSet resultSet = null;
    	
    	try {
    		connection = Database.getConnection();
    		
    		String sql = "SELECT title.name, book.isbn13 " 
    			+ "FROM title, book, publisher "
                + "WHERE title.id = book.title_id AND book.publisher_id = publisher.id;";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				map.put(resultSet.getString("book.isbn13"), resultSet.getString("title.name"));
			}
			return map;
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		} finally {
			Database.close(connection, statement, resultSet);
		}
    	return map;
    }

}
