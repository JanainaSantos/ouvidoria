// Generated by hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge on 12/09/2014 20:29:33-0200.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.model.demandant;

import com.googlecode.ouvidoria.model.demandant.vo.DemandantVO;
import com.googlecode.ouvidoria.model.locality.City;

/**
 * @see Demandant
 */
public class DemandantDaoImpl extends DemandantDaoBase {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void toDemandantVO(Demandant source, DemandantVO target) {
		super.toDemandantVO(source, target);

		if (source.getIdentification() != null) {
			Identification identification = source.getIdentification();
			target.setIdentification(identification.getName());
			target.setIdentificationId(identification.getId());
		}

		if (source.getType() != null) {
			DemandantType type = source.getType();
			target.setType(type.getName());
			target.setTypeId(type.getId());
		}

		if (source.getCity() != null) {
			City city = source.getCity();
			target.setCity(city.getName());
			target.setCityId(city.getId());
			target.setState(city.getState().getName());
			target.setStateId(city.getState().getId());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public DemandantVO toDemandantVO(final Demandant entity) {
		return super.toDemandantVO(entity);
	}

	/**
	 * Retrieves the entity object that is associated with the specified value
	 * object from the object store. If no such entity object exists in the
	 * object store, a new, blank entity is created
	 */
	private Demandant loadDemandantFromDemandantVO(DemandantVO vo) {
		Demandant retorno = null;
		if (vo.getId() == null) {
			retorno = Demandant.Factory.newInstance();
		} else {
			retorno = load(vo.getId());
		}
		return retorno;
	}

	/**
	 * {@inheritDoc}
	 */
	public Demandant demandantVOToEntity(DemandantVO demandantVO) {
		Demandant entity = this.loadDemandantFromDemandantVO(demandantVO);
		this.demandantVOToEntity(demandantVO, entity, true);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void demandantVOToEntity(DemandantVO source, Demandant target, boolean copyIfNull) {
		super.demandantVOToEntity(source, target, copyIfNull);
		
		if(source.getCityId() != null){
			target.setCity(getCityDao().load(source.getCityId()));
		}
		
		if(source.getIdentificationId() != null){
			target.setIdentification(getIdentificationDao().load(source.getIdentificationId()));
		}
		
		if(source.getTypeId() != null){
			target.setType(getDemandantTypeDao().load(source.getTypeId()));
		}
	}
}