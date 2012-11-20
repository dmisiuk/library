package by.minsler.library.dao;

import by.minsler.library.bean.Book;
import by.minsler.library.bean.User;
import by.minsler.library.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookUserDaoImpl implements BookUserDao {

	private static BookUserDaoImpl inst;

	private Connection connection;
	private String getBooksQuery = "select id, name, description, author, date, price, idpublisher from books";
	private String addBookQuery = "insert into books(name, author,description, date, price, idpublisher) values(?,?,?,?,?,?)";
	private String updateBookQuery = "update books set name=?, author=?,description=?, date=?, price=?, idpublisher=? where id=?";
	private String deleteBookQuery = "delete from books where id=?";
	private String getBookQuery = "select * from books where id=?";
	private String getUserQuery = "select * from users where login=? and password=?";
	private String getUserByIdQuery = "select * from users where id=?";
	private PreparedStatement getBooksStatement;
	private PreparedStatement addBookStatement;
	private PreparedStatement deleteBookStatement;
	private PreparedStatement getBookStatement;
	private PreparedStatement getUserStatement;
	private PreparedStatement getUserByIdStatement;
	private PreparedStatement updateBookStatement;

	private BookUserDaoImpl() {
		connection = DBConnection.getInstance().getConnection();
		createStatements();
	}

	private void createStatements() {
		try {
			getBooksStatement = connection.prepareStatement(getBooksQuery);
			addBookStatement = connection.prepareStatement(addBookQuery);
			deleteBookStatement = connection.prepareStatement(deleteBookQuery);
			getBookStatement = connection.prepareStatement(getBookQuery);
			updateBookStatement = connection.prepareStatement(updateBookQuery);
			getUserStatement = connection.prepareStatement(getUserQuery);
			getUserByIdStatement = connection
					.prepareStatement(getUserByIdQuery);
		} catch (SQLException e) {
			System.out.println("error creating statements");
			e.printStackTrace();
		}
	}

	synchronized public static BookUserDaoImpl getInstace() {

		if (inst == null)
			inst = new BookUserDaoImpl();
		return inst;

	}

	@Override
	public List<Book> getBooks() {
		ArrayList<Book> books = new ArrayList<Book>();

		try {
			ResultSet result = getBooksStatement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setId(result.getInt("id"));
				book.setName(result.getString("name"));
				book.setAuthor(result.getString("author"));
				book.setDescription(result.getString("description"));
				book.setDate(result.getString("date"));
				book.setPrice(result.getDouble("price"));
				book.setIdpublihser(result.getInt("idpublisher"));
				book.setUser(getUser(book.getIdpublihser()));
				books.add(book);
			}
		} catch (SQLException e) {

		}

		return books;
	}

	@Override
	public int addBook(Book book) {

		int result = 0;

		try {
			addBookStatement.setString(1, book.getName());
			addBookStatement.setString(2, book.getAuthor());
			addBookStatement.setString(3, book.getDescription());
			addBookStatement.setString(4, book.getDate());
			addBookStatement.setDouble(5, book.getPrice());
			addBookStatement.setInt(6, book.getIdpublihser());
			result = addBookStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int deleteBook(int id) {
		int result = 0;
		try {
			deleteBookStatement.setInt(1, id);
			result = deleteBookStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Book getBook(int id) {
		Book book = new Book();

		try {
			getBookStatement.setInt(1, id);
			ResultSet result = getBookStatement.executeQuery();
			if (result.next()) {
				book.setId(result.getInt("id"));
				book.setName(result.getString("name"));
				book.setAuthor(result.getString("author"));
				book.setDescription(result.getString("description"));
				book.setDate(result.getString("date"));
				book.setPrice(result.getDouble("price"));
				book.setIdpublihser(result.getInt("idpublisher"));
			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;
	}

	@Override
	public int updateBook(Book book) {
		int result = 0;
		try {

			updateBookStatement.setString(1, book.getName());
			updateBookStatement.setString(2, book.getAuthor());
			updateBookStatement.setString(3, book.getDescription());
			updateBookStatement.setString(4, book.getDate());
			updateBookStatement.setDouble(5, book.getPrice());
			updateBookStatement.setInt(6, book.getIdpublihser());
            updateBookStatement.setInt(7,book.getId());
			result = updateBookStatement.executeUpdate();

			result = updateBookStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public User getUser(String login, String password) {

		User user = new User();

		try {
			getUserStatement.setString(1, login);
			getUserStatement.setString(2, password);
			ResultSet result = getUserStatement.executeQuery();
			if (result.next()) {
				user.setId(result.getInt("id"));
				user.setFirstName(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				user.setEmail(result.getString("email"));

			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;

	}

	@Override
	public User getUser(int id) {
		User user = new User();
		System.out.println("user id = " + id);

		try {
			getUserByIdStatement.setInt(1, id);
			ResultSet result = getUserByIdStatement.executeQuery();
			if (result.next()) {
				user.setId(result.getInt("id"));
				user.setFirstName(result.getString("firstname"));
				user.setLastName(result.getString("lastname"));
				user.setEmail(result.getString("email"));
			} else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}
}