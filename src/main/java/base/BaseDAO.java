package base;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import com.mongodb.MongoClient;

import entidades.EntityID;
import entidades.ID;

public abstract class BaseDAO<T extends ID> {

	private Morphia morp = new Morphia();
	private Datastore ds = morp.createDatastore(new MongoClient("localhost"), "carros");

	public abstract Class<T> getClasse();

	public List<T> findAll() {
		return getDs().find(getClasse()).asList();
	}

	public T findByID(Long id) {
		return getDs().find(getClasse()).field("id").equal(id).get();
	}

	public String inserir(T obj) {
		obj.setId(generateId(obj));
		getDs().save(obj);
		return "OK";
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
		Query<EntityID> q = getDs().find(EntityID.class, "_id", collName);

		// create an update operation which increments the counter
		UpdateOperations<EntityID> update = getDs().createUpdateOperations(EntityID.class).inc("counter");

		// execute on server, if not found null is return,
		// else the counter is incremented atomically
		EntityID counter = (EntityID) getDs().findAndModify(q, update);

		if (counter == null) {
			// so just create one
			counter = new EntityID(collName);
			getDs().save(counter);
		}

		// return new id
		return counter.getCounter();
	}

}
