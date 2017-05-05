package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import base.BaseService;
import dao.PerguntaDao;
import entidades.Pergunta;
import entidades.Resposta;

@Stateless
public class PerguntaService extends BaseService<Pergunta> {

	@Inject
	private PerguntaDao perguntaDao;

	@Override
	public Class<Pergunta> getClasse() {
		return Pergunta.class;
	}

	@Override
	protected PerguntaDao getDao() {
		if (perguntaDao == null) {
			perguntaDao = new PerguntaDao();
		}
		return perguntaDao;
	}

	public int adicionarResposta(Pergunta p, Resposta r) {
		return getDao().adicionarResposta(p, r);
	}

	public Pergunta findById(Long id) {
		return getDao().findById(id);
	}

	public List<Pergunta> findByEmail(String email) {
		return getDao().findByEmail(email);
	}
}
