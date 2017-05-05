package entidades;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class EntityID {

	@Id
	private String className;

	// this is the actual ID counter, will
	// be incremented atomically
	private Long counter = 1L;

	public EntityID() {
	}

	public EntityID(String className) {
		this.className = className;
	}

	public Long getCounter() {
		return counter;
	}

	public void setCounter(Long counter) {
		this.counter = counter;
	}

}