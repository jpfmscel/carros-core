package base;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public abstract class BaseDAO<T> {

	private Morphia morp = new Morphia();
	private Datastore ds = morp.createDatastore(new MongoClient("localhost"), "spark");
	
	public abstract Class<T> getClasse();

	public List<T> findAll() {
		return ds.find(getClasse()).asList();
	}

	public void inserir(T obj) {
		ds.save(obj);
		return;
	}

	public void update(T obj) {
		return;
	}

}
