package base;

import java.util.List;

import org.mongodb.morphia.query.Query;

import entidades.EntityID;

public abstract class BaseService<T extends EntityID> {

	public abstract Class<T> getClasse();

	protected abstract BaseDAO<T> getDao();

	public void inserir(T obj) {
		getDao().inserir(obj);
	}

	public int update(T obj) {
		return getDao().update(obj);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}

	public Query<T> getQuery() {
		return getDao().getQuery();
	}

}
