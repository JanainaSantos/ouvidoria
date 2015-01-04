// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::complaint::ComplaintService
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.complaint;

import java.util.Date;
import java.util.List;

import com.googlecode.ouvidoria.ValidationException;
import com.googlecode.ouvidoria.model.complaint.Answer;
import com.googlecode.ouvidoria.model.complaint.Complaint;
import com.googlecode.ouvidoria.model.complaint.ComplaintDao;
import com.googlecode.ouvidoria.model.complaint.enums.ComplaintStatus;
import com.googlecode.ouvidoria.model.complaint.vo.AnswerVO;
import com.googlecode.ouvidoria.model.complaint.vo.ComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.ResumedComplaintVO;
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
	protected SimpleComplaintVO handleSave(ComplaintVO complaintVO)
			throws Exception {
		// salva demandante vo
		Long demandantId = getDemandantService().save(
				complaintVO.getDemandant());
		// recupera demandante entity
		Demandant demandant = getDemandantDao().load(demandantId);
		// converte complaintVO em entity
		Complaint complaint = getComplaintDao()
				.complaintVOToEntity(complaintVO);
		// gera password
		String password = PasswordGenerator.generatePassword();
		String passwordHash = CriptografiaUtils.md5(password);
		complaint.setPassword(passwordHash);
		// seta demandante entity
		complaint.setDemandant(demandant);
		// salva demanda
		SimpleComplaintVO vo = (SimpleComplaintVO) getComplaintDao().create(
				ComplaintDao.TRANSFORM_SIMPLECOMPLAINTVO, complaint);
		// "mostra" o password (para o usr poder checar o andamento)
		vo.setPassword(password);
		// retorna vo
		return vo;
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#checkStatus(Long,
	 *      String)
	 */
	@Override
	protected ComplaintVO handleCheckStatus(Long id, String password)
			throws Exception {
		ComplaintVO vo = (ComplaintVO) getComplaintDao().load(
				ComplaintDao.TRANSFORM_COMPLAINTVO, id);
		if (vo != null) {
			String passwordHash = CriptografiaUtils.md5(password);
			if (vo.getPassword().equals(passwordHash)) {
				return vo;
			}
		}
		return null;
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#search(ComplaintVO)
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected List<ResumedComplaintVO> handleSearch(ComplaintVO criteria)
			throws Exception {
		return (List<ResumedComplaintVO>) getComplaintDao().searchByCriteria(
				ComplaintDao.TRANSFORM_RESUMEDCOMPLAINTVO, criteria);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#validate(ComplaintVO)
	 */
	@Override
	protected boolean handleValidate(ComplaintVO vo) throws Exception {
		// TODO implement protected boolean handleValidate(ComplaintVO vo)
		return true;
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#load(Long)
	 */
	@Override
	protected ComplaintVO handleLoad(Long id) throws Exception {
		return (ComplaintVO) getComplaintDao().load(
				ComplaintDao.TRANSFORM_COMPLAINTVO, id);
	}

	@Override
	protected void handleAnswer(AnswerVO vo) throws Exception {
		if (vo.getComplaintId() != null) {
			Complaint complaint = getComplaintDao().load(vo.getComplaintId());

			if (ComplaintStatus.CLOSED == complaint.getStatus()
					|| ComplaintStatus.DISCARDED == complaint.getStatus()) {
				throw new ValidationException(
						"The complaint can't be answered if it is closed or discarded");
			}

			Answer answer = getAnswerDao().answerVOToEntity(vo);
			answer.setComplaint(complaint);
			answer.setDate(new Date());
			getAnswerDao().create(answer);

			complaint.setStatus(ComplaintStatus.ANALYSING);
			getComplaintDao().update(complaint);
		} else {
			throw new IllegalArgumentException("Complaint ID must not be null");
		}
	}

	@Override
	protected void handleClose(Long complaintId) throws Exception {
		List<Answer> answers = getAnswerDao().findByComplaintId(complaintId);
		if (answers.isEmpty()) {
			throw new ValidationException(
					"The complaint must have at least one answer to be closed");
		}
		Complaint complaint = getComplaintDao().load(complaintId);
		complaint.setStatus(ComplaintStatus.CLOSED);
		getComplaintDao().update(complaint);
	}

}