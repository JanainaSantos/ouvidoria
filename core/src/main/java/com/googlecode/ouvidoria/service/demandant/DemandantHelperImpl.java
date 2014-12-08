// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::demandant::DemandantHelper
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.demandant;

import com.googlecode.ouvidoria.model.demandant.DemandantTypeDao;
import com.googlecode.ouvidoria.model.demandant.IdentificationDao;
import com.googlecode.ouvidoria.model.demandant.enums.Sex;
import com.googlecode.ouvidoria.model.vo.SimpleVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @see com.googlecode.ouvidoria.service.demandant.DemandantHelper
 */
public class DemandantHelperImpl extends DemandantHelperBase {

	/**
	 * @see com.googlecode.ouvidoria.service.demandant.DemandantHelper#getDemandantTypes()
	 */
	@Override
	protected List<SimpleVO> handleGetDemandantTypes() throws Exception {
		return (List<SimpleVO>) getDemandantTypeDao().searchActive(DemandantTypeDao.TRANSFORM_SIMPLEVO);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.demandant.DemandantHelper#getIdentificationTypes()
	 */
	@Override
	protected List<SimpleVO> handleGetIdentificationTypes() throws Exception {
		return (List<SimpleVO>) getIdentificationDao().searchActive(IdentificationDao.TRANSFORM_SIMPLEVO);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.demandant.DemandantHelper#getSexTypes()
	 */
	@Override
	protected List<SimpleVO> handleGetSexTypes() throws Exception {
		List<SimpleVO> list = new ArrayList<>();
		for(Sex s: Sex.values()){
			list.add(new SimpleVO(null, s.getValue(), s.getValue(), true));
		}
		return list;
	}

}