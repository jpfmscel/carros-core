package entidades;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexes;

@Entity("pergunta")
@Indexes(@Index(value = "id", fields = @Field("id")))
public class Resposta {

	public Resposta() {

	}

	public Resposta(String texto, String userEmail, Boolean respostaCurta) {
		setTexto(texto);
		setUserEmail(userEmail);
		setRespostaCurta(respostaCurta);
	}

	private String texto;
	private String userEmail;
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

}
