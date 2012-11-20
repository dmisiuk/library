package by.minsler.library.dao;

import java.util.List;

import by.minsler.library.bean.Book;
import by.minsler.library.bean.User;

public interface BookUserDao {

	List<Book> getBooks();

	int addBook(Book book);

	int deleteBook(int id);

	Book getBook(int id);

	int updateBook(Book book);

	User getUser(String login, String password);

	User getUser(int id);
}
