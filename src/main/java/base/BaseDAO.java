package base;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mongodb.MongoClient;

public abstract class BaseDAO<T> {

	private Morphia morp = new Morphia();
	private Datastore ds = morp.createDatastore(new MongoClient("localhost"), "carros");

	public abstract Class<T> getClasse();

	public List<T> findAll() {
		return getDs().find(getClasse()).asList();
	}

	public void inserir(T obj) {
		getDs().save(obj);
		return;
	}

	public int update(T obj) {
		UpdateOperations<T> ope = getDs().createUpdateOperations(getClasse());
		UpdateResults update = getDs().update(obj, ope);
		return update.getUpdatedCount();
	}

	public Query<T> getQuery() {
		return (Query<T>) getDs().createQuery(getClasse());
	}

	public Datastore getDs() {
		return ds;
	}

}
