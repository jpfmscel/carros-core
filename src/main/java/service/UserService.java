package service;

import java.util.List;

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

	@Override
	public String inserir(User obj) {
		User findByEmail = findByEmail(obj.getEmail());

		if (findByEmail == null) {
			return super.inserir(obj);
		}

		return "[FAILURE] User already registered.";
	}

	public User findByEmail(String email) {
		return getDao().findByEmail(email);
	}

	public List<User> findByName(String name) {
		return getDao().findByName(name);
	}

	public boolean authenticate(User u) {
		return getDao().authenticate(u);
	}


}
