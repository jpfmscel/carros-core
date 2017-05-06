package base;

import java.util.List;

import org.mongodb.morphia.query.Query;

import entidades.ID;

public abstract class BaseService<T extends ID> {

	public abstract Class<T> getClasse();

	protected abstract BaseDAO<T> getDao();

	public String inserir(T obj) {
		return getDao().inserir(obj);
	}

	public int update(T obj) {
		return getDao().update(obj);
	}

	public T findByID(Long id) {
		return getDao().findByID(id);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}

	public Query<T> getQuery() {
		return getDao().getQuery();
	}

}
