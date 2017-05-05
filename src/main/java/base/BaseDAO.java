package base;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mongodb.MongoClient;

import entidades.EntityID;

public abstract class BaseDAO<T extends EntityID> {

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

	protected Long generateId(T entity) {
		// lookup the collection name for the entity
		String collName = getDs().getCollection(getClasse()).getName();

		// find any existing counters for the type
		Query<T> q = getDs().find(getClasse(), "_id", collName);

		// create an update operation which increments the counter
		UpdateOperations<T> update = getDs().createUpdateOperations(getClasse()).inc("counter");

		// execute on server, if not found null is return,
		// else the counter is incremented atomically
		EntityID counter = getDs().findAndModify(q, update);

		if (counter == null) {
			// so just create one
			counter = new EntityID(collName);
			getDs().save(counter);
		}

		// return new id
		return counter.getCounter();
	}

}
