package service;

import javax.inject.Inject;

import base.BaseService;
import dao.PerguntaDao;
import entidades.Pergunta;
import entidades.Resposta;

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
}
