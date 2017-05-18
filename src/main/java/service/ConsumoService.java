package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import base.BaseService;
import dao.ConsumoDao;
import entidades.Consumo;

@Stateless
public class ConsumoService extends BaseService<Consumo> {

	@Inject
	private ConsumoDao consumoDao;

	@Override
	public Class<Consumo> getClasse() {
		return Consumo.class;
	}

	@Override
	protected ConsumoDao getDao() {
		if (consumoDao == null) {
			consumoDao = new ConsumoDao();
		}
		return consumoDao;
	}

	public Consumo findById(Long id) {
		return getDao().findById(id);
	}

}
