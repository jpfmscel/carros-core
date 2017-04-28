package base;

import java.util.List;

import org.mongodb.morphia.query.Query;

public abstract class BaseService<T> {

	public abstract Class<T> getClasse();

	protected abstract BaseDAO<T> getDao();

	public void inserir(T obj) {
		getDao().inserir(obj);
	}

	public void update(T obj) {
		getDao().update(obj);
	}

	public List<T> findAll() {
		return getDao().findAll();
	}
	
	public Query<T> getQuery(){
		return getDao().getQuery();
	}

}
