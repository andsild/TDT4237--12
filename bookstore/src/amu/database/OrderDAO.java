package amu.database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import amu.model.Book;
import amu.model.Cart;
import amu.model.CartItem;
import amu.model.Customer;
import amu.model.Order;

public class OrderDAO {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	public List<Order> browse(Customer customer) {
		List<Order> orders = new ArrayList<Order>();

		try {
			connection = Database.getConnection();
			String query = "SELECT * FROM `order` WHERE customer_id=? AND order_id = 0";
			statement = connection.prepareStatement(query);
			statement.setInt(1, customer.getId());
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				AddressDAO addressDAO = new AddressDAO();
				Calendar createdDate = Calendar.getInstance();
				createdDate.setTime(resultSet.getDate("created"));
				orders.add(new Order(resultSet.getInt("id"), customer,
						addressDAO.read(resultSet.getInt("address_id"),
								customer.getId()), createdDate, resultSet
								.getString("value"), resultSet.getInt("status")));
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return orders;
	}

	public boolean add(Order order) {

		try {
			connection = Database.getConnection();

			String query = "INSERT INTO `order` (customer_id, address_id, created, value, status) VALUES (?, ?, CURDATE(), ?, ?)";
			statement = connection.prepareStatement(query,
					Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, order.getCustomer().getId());
			statement.setInt(2, order.getAddress().getId());
			statement.setBigDecimal(3, new BigDecimal(order.getValue()));
			statement.setInt(4, order.getStatus());
			statement.executeUpdate();

			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				System.out.println("Inserted into row: " + resultSet.getInt(1));
				String itemquery = "INSERT INTO order_items (order_id, book_id, quantity, price, status) VALUES (?, ?, ?, ?, ?)";
				for (CartItem item : order.getCart().getItems().values()) {
					statement = connection.prepareStatement(itemquery);
					statement.setInt(1, resultSet.getInt(1));
					statement.setInt(2, item.getBook().getId());
					statement.setInt(3, item.getQuantity());
					statement.setFloat(4,
							item.getBook().getPrice() * item.getQuantity());
					statement.setInt(5, 0);
					statement.execute();
					System.out.println("book inserted");

				}
				return true;
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return false;
	}

	public Cart getCart(Order order) {

		Cart cart = new Cart();
		try {
			connection = Database.getConnection();

			String query = "SELECT * FROM order_items WHERE order_id = ?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, order.getId());

			resultSet = statement.executeQuery();

			BookDAO bookDao = new BookDAO();
			while (resultSet.next()) {
				Book book = new Book();
				System.out.println(resultSet.getString("book_id"));
				book = bookDao.findByID(resultSet.getString("book_id"));
				cart.addItem(new CartItem(book, resultSet.getInt("quantity")));
			}

		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return cart;

	}

	public Order getOrder(Customer customer, int id) {

		Order order = null;
		try {
			connection = Database.getConnection();
			String query = "SELECT * FROM `order` WHERE customer_id=? AND id=?";
			statement = connection.prepareStatement(query);
			statement.setInt(1, customer.getId());
			statement.setInt(2, id);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				AddressDAO addressDAO = new AddressDAO();
				Calendar createdDate = Calendar.getInstance();
				createdDate.setTime(resultSet.getDate("created"));
				order = (new Order(resultSet.getInt("id"), customer,
						addressDAO.read(resultSet.getInt("address_id"),
								customer.getId()), createdDate,
						resultSet.getString("value"),
						resultSet.getInt("status")));
				order.setCart(getCart(order));
			}
		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return order;
	}

	public boolean removeOrder(Order order) {
		if (order.getStatus() == 0) {

			try {

				if (!editOrder(order, -1)) {
					return false;
				}
				connection = Database.getConnection();

				String query = "INSERT INTO `order` (customer_id, address_id, created, value, status, order_id) VALUES (?, ?, CURDATE(), ?, ?, ?)";
				statement = connection.prepareStatement(query,
						Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, order.getCustomer().getId());
				statement.setInt(2, order.getAddress().getId());
				statement.setBigDecimal(3, new BigDecimal(order.getValue()));
				statement.setInt(4, -1);
				statement.setInt(5, order.getId());
				statement.executeUpdate();

				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					String itemquery = "INSERT INTO order_items (order_id, book_id, quantity, price, status) VALUES (?, ?, ?, ?, ?)";
					for (CartItem item : order.getCart().getItems().values()) {
						statement = connection.prepareStatement(itemquery);
						statement.setInt(1, resultSet.getInt(1));
						statement.setInt(2, item.getBook().getId());
						statement.setInt(3, item.getQuantity() * -1);
						statement.setFloat(4,
								item.getBook().getPrice() * item.getQuantity());
						statement.setInt(5, -1);
						statement.execute();
						System.out.println("book inserted");

					}
					return true;
				}
			} catch (SQLException exception) {
				Logger.getLogger(this.getClass().getName()).log(Level.SEVERE,
						null, exception);
			} finally {
				Database.close(connection, statement, resultSet);
			}
		}

		return false;
	}

	public boolean editOrder(Order order, int status) {

		try {
			connection = Database.getConnection();

			String query = "UPDATE `order` SET `status`=? WHERE `id`=?";
			statement = connection.prepareStatement(query);

			statement.setInt(1, status);
			statement.setInt(2, order.getId());

			if (statement.executeUpdate() == 0) {
				return false; // No rows were affected
			} else {
				return true;
			}

		} catch (SQLException exception) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null,
					exception);
		} finally {
			Database.close(connection, statement, resultSet);
		}

		return false;
	}
}
