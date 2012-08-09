package by.minsler.library.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.library.bean.Book;
import by.minsler.library.dao.BookUserDao;
import by.minsler.library.dao.MysqlBookUserDao;

public class ShowCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request
				.getRequestDispatcher("/WEB-INF/jsp/book/show.jsp");
		BookUserDao dao = MysqlBookUserDao.getInstace();
		List<Book> list = dao.getBooks();
		request.setAttribute("list", list);

		view.forward(request, response);
	}
}
