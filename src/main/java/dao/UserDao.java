package dao;

import javax.ejb.Stateless;

import base.BaseDAO;
import entidades.User;

@Stateless
public class UserDao extends BaseDAO<User>{

	@Override
	public Class<User> getClasse() {
		return User.class;
	}

}
