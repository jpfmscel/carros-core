package dao;

import javax.ejb.Stateless;

import base.BaseDAO;
import entidades.Consumo;

@Stateless
public class ConsumoDao extends BaseDAO<Consumo> {

	@Override
	public Class<Consumo> getClasse() {
		return Consumo.class;
	}

	public Consumo findById(Long id) {
		return getDs().find(getClasse()).field("id").equal(id).get();
	}

}
