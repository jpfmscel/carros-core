package entidades;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Field;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Indexes;
import org.mongodb.morphia.annotations.Property;

@Entity("pergunta")
@Indexes(@Index(value = "perguntaId", fields = @Field("perguntaId")))
public class Pergunta {

	public Pergunta(String texto, String userEmail) {
		setUserEmail(userEmail);
		setTexto(texto);
	}

	public Pergunta() {
	}

	@Id
	private ObjectId _id;

	@Indexed
	private long perguntaId;

	@Property
	private String texto;

	@Property
	private String userEmail;

	private List<Resposta> respostas;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Resposta> getRespostas() {
		if (respostas == null) {
			respostas = new ArrayList<>();
		}
		return respostas;
	}

	public void setRespostas(List<Resposta> respostas) {
		this.respostas = respostas;
	}

	public long getPerguntaId() {
		return perguntaId;
	}

	public void setPerguntaId(long perguntaId) {
		this.perguntaId = perguntaId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

}
