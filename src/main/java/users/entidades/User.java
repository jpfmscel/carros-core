package users.entidades;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;

@Entity("user")
@Indexes(@Index(value = "email", fields = @Field("email")))
public class User {

	public User() {
	}
	
	public User(String email, String name, String password, Date creationDate) {
		setEmail(email);
		setName(name);
		setPassword(password);
		setCreationDate(creationDate);
	}

	@Id
	private ObjectId id;

	@Property
	private String email;

	@Property
	private String name;

	@Property
	private String password;

	@Property
	private Date creationDate;

	private List<Pergunta> perguntasFeitas;
	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", creationDate="
				+ creationDate + "]";
	}

	public List<Pergunta> getPerguntasFeitas() {
		return perguntasFeitas;
	}

	public void setPerguntasFeitas(List<Pergunta> perguntasFeitas) {
		this.perguntasFeitas = perguntasFeitas;
	}

}
