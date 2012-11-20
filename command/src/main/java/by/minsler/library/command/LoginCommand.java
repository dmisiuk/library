package by.minsler.library.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.minsler.library.bean.User;
import by.minsler.library.service.CheckUser;

public class LoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (user == null) {
			user = CheckUser.valid(login, password);
			if (user != null) {
				session.setAttribute("user", user);
				response.sendRedirect("book");
			} else {
				response.sendRedirect("index.jsp");
			}
		} else {
			response.sendRedirect("book");
		}
	}
}
