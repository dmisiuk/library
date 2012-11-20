package by.minsler.library.service;

import by.minsler.library.bean.User;
import by.minsler.library.dao.BookUserDao;
import by.minsler.library.dao.BookUserDaoImpl;

public class CheckUser {

	public static User valid(String login, String password) {
		User user = null;
		BookUserDao dao = BookUserDaoImpl.getInstace();
		user = dao.getUser(login, password);
		return user;
	}

}
