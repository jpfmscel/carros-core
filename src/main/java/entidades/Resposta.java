package entidades;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("resposta")
public class Resposta extends EntityID {

	public Resposta() {

	}

	public Resposta(String texto, String userEmail, Boolean respostaCurta) {
		setTexto(texto);
		setUserEmail(userEmail);
		setRespostaCurta(respostaCurta);
	}

	@Id
	private ObjectId _id;

	@Property
	private Long id;

	@Property
	private String texto;

	@Property
	private String userEmail;

	@Property
	private Boolean respostaCurta;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Boolean getRespostaCurta() {
		return respostaCurta;
	}

	public void setRespostaCurta(Boolean respostaCurta) {
		this.respostaCurta = respostaCurta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
