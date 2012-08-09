package by.minsler.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.library.bean.User;
import by.minsler.library.command.AddCommand;
import by.minsler.library.command.AddWriteCommand;
import by.minsler.library.command.Command;
import by.minsler.library.command.DeleteCommand;
import by.minsler.library.command.EditCommand;
import by.minsler.library.command.EditWriteCommand;
import by.minsler.library.command.ShowCommand;

public class BookController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			response.sendRedirect("index.jsp");
		} else {

			String operation = request.getParameter("operation");
			Command command = null;
			if (operation == null) {
				command = new ShowCommand();
			} else if (operation.equals("add")) {
				command = new AddCommand();
			} else if (operation.equals("addWrite")) {
				command = new AddWriteCommand();
			} else if (operation.equals("edit")) {
				command = new EditCommand();
			} else if (operation.equals("delete")) {
				command = new DeleteCommand();
			} else if (operation.equals("editWrite")) {
				command = new EditWriteCommand();
			} else {
				command = new ShowCommand();
			}
			command.execute(request, response);
		}
	}
}
