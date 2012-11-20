package by.minsler.library.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.library.bean.Book;
import by.minsler.library.dao.BookUserDao;
import by.minsler.library.dao.BookUserDaoImpl;

public class EditCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookUserDao dao = BookUserDaoImpl.getInstace();

		int id = Integer.parseInt(request.getParameter("id"));
		Book book = dao.getBook(id);
		request.setAttribute("book", book);
		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/jsp/book/edit.jsp");

		view.forward(request, response);
	}
}
