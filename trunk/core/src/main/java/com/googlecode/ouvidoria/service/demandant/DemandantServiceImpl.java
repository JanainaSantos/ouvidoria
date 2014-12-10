// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::demandant::DemandantService
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.demandant;

import com.googlecode.ouvidoria.model.demandant.Demandant;
import com.googlecode.ouvidoria.model.demandant.vo.DemandantVO;

import com.google.gson.Gson;

/**
 * @see com.googlecode.ouvidoria.service.demandant.DemandantService
 */
public class DemandantServiceImpl extends DemandantServiceBase {

	/**
	 * @see com.googlecode.ouvidoria.service.demandant.DemandantService#save(DemandantVO)
	 */
	@Override
	protected Long handleSave(DemandantVO demandantVO) throws Exception {
		System.out.println("SAVE: "+demandantVO);
		
		Gson gson = new Gson();
		 
		// convert java object to JSON format,
		// and returned as JSON formatted string
		//String json = gson.toJson(obj);
		
		// transforma vo em entity
		Demandant demandant = getDemandantDao().demandantVOToEntity(demandantVO);
		System.out.println("((((((((((((before) DEMANDANT_VO="+gson.toJson(demandantVO));
		// salva entity
		Demandant newDemandant = getDemandantDao().create(demandant);
		System.out.println("((((((((((((after) DEMANDANT="+newDemandant.getId());
		// retorna id
		return newDemandant.getId();
	}

}