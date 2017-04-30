package dao;

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

}
