package by.minsler.library.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.library.bean.Book;
import by.minsler.library.dao.BookUserDao;
import by.minsler.library.dao.MysqlBookUserDao;

public class EditWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookUserDao dao = MysqlBookUserDao.getInstace();

		Book book = new Book();
		book.setName(request.getParameter("name"));
		book.setAuthor(request.getParameter("author"));
		book.setDescription(request.getParameter("description"));
		book.setDate(request.getParameter("date"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setIdpublihser(Integer.parseInt(request
				.getParameter("idpublisher")));

		dao.updateBook(book);
		try {
			response.sendRedirect("book");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
