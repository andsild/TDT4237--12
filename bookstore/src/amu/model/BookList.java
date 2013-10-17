package amu.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BookList implements Serializable {

	private Map<String, Book> list = new HashMap<String, Book>();
	private String title;
	private String description;
	private int id;
	private Customer customer;
	
	public BookList(int id, String title, String description){
		this.setId(id);
		this.setTitle(title);
		this.setDescription(description);
	}

	public BookList() {
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Map<String, Book> getList() {
		return list;
	}

	public boolean hasBookByISBN(String isbn) {
		if (list.get(isbn) == null) {
			return false;

		} else {
			return true;
		}
	}

	public void addBook(Book book) {
		String isbn = book.getIsbn13();
		if (!hasBookByISBN(isbn)) {
			list.put(isbn, book);
		}
	}

	public void removeBook(Book book) {
		String isbn = book.getIsbn13();
		if (hasBookByISBN(isbn)) {
			list.remove(isbn);
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
		//TODO input validation
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
