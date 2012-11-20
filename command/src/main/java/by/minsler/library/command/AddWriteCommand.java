package by.minsler.library.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.minsler.library.bean.Book;
import by.minsler.library.bean.User;
import by.minsler.library.dao.BookUserDao;
import by.minsler.library.dao.MysqlBookUserDao;

public class AddWriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookUserDao dao = MysqlBookUserDao.getInstace();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		Book book = new Book();
		book.setName(request.getParameter("name"));
		book.setAuthor(request.getParameter("author"));
		book.setDescription(request.getParameter("description"));
		book.setDate(request.getParameter("date"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setIdpublihser(user.getId());

		dao.addBook(book);
		try {
			response.sendRedirect("book");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
