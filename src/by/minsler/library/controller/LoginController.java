package by.minsler.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.minsler.library.command.CheckUserIdCommand;
import by.minsler.library.command.Command;
import by.minsler.library.command.LoginCommand;
import by.minsler.library.command.LogoutCommand;

public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		Command command;

		String operation = request.getParameter("operation");
		if (operation == null) {
			command = new CheckUserIdCommand();
		} else if (operation.equals("login")) {
			command = new LoginCommand();
		} else if (operation.equals("logout")) {
			command = new LogoutCommand();
		} else {
			command = new CheckUserIdCommand();
		}
		command.execute(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
