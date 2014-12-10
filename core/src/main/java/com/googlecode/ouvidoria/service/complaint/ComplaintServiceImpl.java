// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::complaint::ComplaintService
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.complaint;

import java.util.List;

import com.google.gson.Gson;
import com.googlecode.ouvidoria.model.complaint.Complaint;
import com.googlecode.ouvidoria.model.complaint.ComplaintDao;
import com.googlecode.ouvidoria.model.complaint.vo.ComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.SimpleComplaintVO;
import com.googlecode.ouvidoria.model.demandant.Demandant;
import com.googlecode.ouvidoria.util.criptografia.CriptografiaUtils;
import com.googlecode.ouvidoria.util.criptografia.PasswordGenerator;

/**
 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService
 */
public class ComplaintServiceImpl extends ComplaintServiceBase {

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#save(ComplaintVO)
	 */
	@Override
	protected SimpleComplaintVO handleSave(ComplaintVO complaintVO) throws Exception {
		System.out.println("COMPLAINT.SAVE: "+complaintVO);
		Gson gson = new Gson();
		System.out.println("complaintVO="+gson.toJson(complaintVO));
		// salva demandante vo
		Long demandantId = getDemandantService().save(complaintVO.getDemandant());
		System.out.println("_____ID="+demandantId);
		// recupera demandante entity
		Demandant demandant = getDemandantDao().load(demandantId);
		System.out.println("demandante="+demandant);
		// converte complaintVO em entity
		Complaint complaint = getComplaintDao().complaintVOToEntity(complaintVO);
		// gera password
		String password = PasswordGenerator.generatePassword();
		String passwordHash = CriptografiaUtils.md5(password);
		complaint.setPassword(passwordHash);
		// seta demandante entity
		complaint.setDemandant(demandant);
		// salva complaint
		SimpleComplaintVO vo = (SimpleComplaintVO) getComplaintDao().create(
				ComplaintDao.TRANSFORM_SIMPLECOMPLAINTVO, complaint);
		// "mostra" o password (para o usr poder checar o andamento)
		vo.setPassword(password);
		// retorna vo
		System.out.println("VO="+gson.toJson(vo));
		return vo;
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#checkStatus(Long,
	 *      String)
	 */
	@Override
	protected ComplaintVO handleCheckStatus(Long id, String password) throws Exception {
		ComplaintVO vo = (ComplaintVO) getComplaintDao().load(ComplaintDao.TRANSFORM_COMPLAINTVO, id);
		if(vo != null){
			String passwordHash = CriptografiaUtils.md5(password);
			if(vo.getPassword().equals(passwordHash)){
				return vo;
			}
		}
		return null;
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#get(Long)
	 */
	@Override
	protected ComplaintVO handleGet(Long id) throws Exception {
		return (ComplaintVO) getComplaintDao().load(ComplaintDao.TRANSFORM_COMPLAINTVO, id);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#search(ComplaintVO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected List<ComplaintVO> handleSearch(ComplaintVO criteria) throws Exception {
		return (List<ComplaintVO>) getComplaintDao().searchByCriteria(ComplaintDao.TRANSFORM_COMPLAINTVO, criteria);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#validate(ComplaintVO)
	 */
	@Override
	protected boolean handleValidate(ComplaintVO vo) throws Exception {
		// TODO implement protected boolean handleValidate(ComplaintVO vo)
		return true;
	}

}