// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::maintenance::LocalityService
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.maintenance;

import com.googlecode.ouvidoria.model.locality.CityDao;
import com.googlecode.ouvidoria.model.locality.StateDao;
import com.googlecode.ouvidoria.model.vo.SimpleVO;

import java.util.List;

/**
 * @see com.googlecode.ouvidoria.service.maintenance.LocalityService
 */
public class LocalityServiceImpl extends LocalityServiceBase {

	/**
	 * @see com.googlecode.ouvidoria.service.maintenance.LocalityService#listStates()
	 */
	@Override
	protected List<SimpleVO> handleListStates() throws Exception {
		return (List<SimpleVO>) getStateDao().searchActive(StateDao.TRANSFORM_SIMPLEVO);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.maintenance.LocalityService#listCities(Long)
	 */
	@Override
	protected List<SimpleVO> handleListCities(Long stateId) throws Exception {
		return (List<SimpleVO>) getCityDao().searchByState(CityDao.TRANSFORM_SIMPLEVO, stateId);
	}

}