package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import base.BaseService;
import dao.UserDao;
import entidades.User;

@Stateless
public class UserService extends BaseService<User> {

	@Inject
	private UserDao userDao;

	@Override
	public Class<User> getClasse() {
		return User.class;
	}

	@Override
	protected UserDao getDao() {
		if (userDao == null) {
			userDao = new UserDao();
		}
		return userDao;
	}

}