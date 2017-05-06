package dao;

import java.util.List;

import javax.ejb.Stateless;

import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import base.BaseDAO;
import entidades.Pergunta;
import entidades.Resposta;

@Stateless
public class PerguntaDao extends BaseDAO<Pergunta> {

	@Override
	public Class<Pergunta> getClasse() {
		return Pergunta.class;
	}

	public int adicionarResposta(Pergunta p, Resposta r) {
		UpdateOperations<Pergunta> ope = getDs().createUpdateOperations(getClasse()).addToSet("respostas", r);
		UpdateResults update = getDs().update(p, ope);
		return update.getUpdatedCount();
	}

	public Pergunta findById(Long id) {
		return getDs().find(getClasse()).field("id").equal(id).get();
	}

	public List<Pergunta> findByEmail(String email) {
		return getDs().find(getClasse()).field("userEmail").equal(email).asList();
	}

}
