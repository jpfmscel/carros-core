package entidades;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("user")
public class User extends EntityID {

	public User() {
	}

	public User(String email, String name, String password, Date creationDate) {
		setEmail(email);
		setName(name);
		setPassword(password);
		setCreationDate(creationDate);
	}

	@Id
	private ObjectId _id;

	@Property
	private Long id;

	@Property
	private String email;

	@Property
	private String name;

	@Property
	private String password;

	@Property
	private Date creationDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
