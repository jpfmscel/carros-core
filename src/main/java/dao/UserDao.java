package dao;

import java.util.List;

import javax.ejb.Stateless;

import base.BaseDAO;
import entidades.User;

@Stateless
public class UserDao extends BaseDAO<User> {

	@Override
	public Class<User> getClasse() {
		return User.class;
	}

	public User findByEmail(String email) {
		return getDs().find(getClasse()).field("email").equalIgnoreCase(email).get();
	}

	public List<User> findByName(String name) {
		return getDs().find(getClasse()).field("name").equalIgnoreCase(name).asList();
	}

}
