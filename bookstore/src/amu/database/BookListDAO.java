package amu.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import amu.model.Book;
import amu.model.BookList;
import amu.model.Publisher;
import amu.model.Title;

public class BookListDAO {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	public BookList findByID(int id) {
		BookList list = new BookList();
		Book book;

		try {
			connection = Database.getConnection();

			String query = "SELECT * FROM  book, publisher, title, list, list_x_book, customer " + "WHERE list.ID = ? " + "AND book.title_id = title.id "
					+ "AND book.publisher_id = publisher.id " + "AND book.id = list_x_book.id_book " + "AND list_x_book.ID_list = ? "
					+ "AND list.customer_id = customer.id ";

			statement = connection.prepareStatement(query);

			statement.setInt(1, id);
			statement.setInt(2, id);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AuthorDAO authorDAO = new AuthorDAO(); 
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

				list.addBook(book);
				System.out.println(book.toString());
			}
			resultSet.first();
			list.setTitle(resultSet.getString("list.title"));
			list.setDescription(resultSet.getString("list.description"));
			list.setCustomer(new CustomerDAO().findByEmail(resultSet.getString("customer.email")));
			System.out.println(list.getCustomer().toString());
			System.out.println("HEEEELLOOO");
			resultSet.afterLast();

		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
		} finally {
			Database.close(connection, statement, resultSet);

		}
		return list;
	}

	public ArrayList<BookList> getBooklists(int customerId) {

		ArrayList<BookList> array = new ArrayList<BookList>();

		try {
			connection = Database.getConnection();

			String query = "Select * FROM list WHERE customer_id = ?";

			statement = connection.prepareStatement(query);

			statement.setInt(1, customerId);

			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				array.add(new BookList(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description")));

			}
			return array;
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		} finally {
			Database.close(connection, statement, resultSet);
		}
		return array;
	}

	public ArrayList<BookList> getBooklists() {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<BookList> array = new ArrayList<BookList>();

		try {
			connection = Database.getConnection();
			statement = connection.createStatement();

			String query = "Select * FROM list";

			resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				array.add(new BookList(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("description")));

			}
			return array;
		} catch (SQLException e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
		} finally {
			Database.close(connection, statement, resultSet);
		}
		return array;
	}

	public boolean edit(BookList bookList) {

		try {
			connection = Database.getConnection();

			String query = "UPDATE INTO list (customer_id, title, description) VALUES (?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, bookList.getCustomer().getId());
			statement.setString(2, bookList.getTitle());
			statement.setString(3, bookList.getDescription());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return false;
	}

	public boolean add(BookList bookList) {

		try {
			connection = Database.getConnection();

			String query = "INSERT INTO list (customer_id, title, description) VALUES (?, ?, ?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, bookList.getCustomer().getId());
			statement.setString(2, bookList.getTitle());
			statement.setString(3, bookList.getDescription());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return false;
	}

	public boolean delete(int id, int customer_id) {

		try {
			connection = Database.getConnection();

			String query = "DELETE FROM booklist WHERE id=? AND customer_id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setInt(2, customer_id);

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return false;
	}

	public boolean addBook(Book book, int id) {

		try {
			connection = Database.getConnection();

			String query = "INSERT INTO list_x_book (ID_list, ID_book) VALUES (?, ?)";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setInt(2, book.getId());
			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return false;
	}

	public boolean deleteBook(int id, Book book) {

		try {
			connection = Database.getConnection();

			String query = "DELETE FROM list_x_book WHERE ID_List=? AND ID_book=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.setInt(2, book.getId());

			if (statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return false;
	}
}
