package by.minsler.library.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.library.dao.BookUserDao;
import by.minsler.library.dao.MysqlBookUserDao;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookUserDao dao = MysqlBookUserDao.getInstace();

		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteBook(id);
		try {
			response.sendRedirect("book");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
