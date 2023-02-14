package task01.service.impl;

import java.util.List;

import task01.dao.UserDao;
import task01.dao.impl.UserDaoImpl;
import task01.domain.User;
import task01.service.UserService;

public class UserServiceImpl implements UserService {
	private static UserService userServiceImpl;
	private UserDao userDao;

	private UserServiceImpl() {
		userDao = new UserDaoImpl();
	}

	public static UserService getUserService() {
		if (userServiceImpl == null) {
			userServiceImpl = new UserServiceImpl();
		}
		return userServiceImpl;
	}

	@Override
	public User create(User user) {
		return userDao.create(user);
	}

	@Override
	public List<User> readAll() {
		return userDao.readAll();
	}

	@Override
	public User read(Integer id) {
		return userDao.read(id);
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

	@Override
	public void delete(Integer id) {
		userDao.delete(id);
	}

}