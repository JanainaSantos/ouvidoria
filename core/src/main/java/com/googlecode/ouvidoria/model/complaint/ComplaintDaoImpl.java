// Generated by hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge on 12/10/2014 13:43:10-0200.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.model.complaint;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.googlecode.ouvidoria.model.complaint.vo.AnswerVO;
import com.googlecode.ouvidoria.model.complaint.vo.ComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.ResumedComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.SimpleComplaintVO;

/**
 * @see Complaint
 */
public class ComplaintDaoImpl extends ComplaintDaoBase {
	
	@Override
    @SuppressWarnings("unchecked")
    public List<?> searchByCriteria(final int transform, final String queryString, int pageNumber, int pageSize, final ComplaintVO vo) {
		Criteria criteria = this.getSession().createCriteria(Complaint.class);
		
		if(vo != null){
			if(vo.getId() != null){
				criteria.add(Restrictions.idEq(vo.getId()));
			} else{
				if(vo.getStatus() != null){
					System.out.println("DAO .... "+ vo.getStatus());
					criteria.add(Restrictions.eq("status", vo.getStatus()));
				}
				//TODO demandant
				if(vo.getSubjectId() != null){
					criteria.createCriteria("subject").add(Restrictions.idEq(vo.getSubjectId()));
				}
				if(vo.getText() != null){
					criteria.add(Restrictions.ilike("text", "%" + vo.getText() + "%"));
				}
				if(vo.getTypeId() != null){
					criteria.createCriteria("type").add(Restrictions.idEq(vo.getTypeId()));
				}
			}
		}
		criteria.addOrder(Order.desc("date"));
		
		if (pageNumber > 0 && pageSize > 0)
        {
			criteria.setFirstResult(super.calculateFirstResult(pageNumber, pageSize));
			criteria.setMaxResults(pageSize);
        }
		
        List results = criteria.list();
        transformEntities(transform, results);
        return results;
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void toSimpleComplaintVO(Complaint source, SimpleComplaintVO target) {
		super.toSimpleComplaintVO(source, target);
		target.setDate(source.getDate());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SimpleComplaintVO toSimpleComplaintVO(final Complaint entity) {
		return super.toSimpleComplaintVO(entity);
	}

	/**
	 * Retrieves the entity object that is associated with the specified value
	 * object from the object store. If no such entity object exists in the
	 * object store, a new, blank entity is created
	 */
	private Complaint loadComplaintFromSimpleComplaintVO(SimpleComplaintVO vo) {
		Complaint retorno = null;
		if (vo.getId() == null) {
			retorno = Complaint.Factory.newInstance();
		} else {
			retorno = load(vo.getId());
		}
		return retorno;
	}

	/**
	 * {@inheritDoc}
	 */
	public Complaint simpleComplaintVOToEntity(
			SimpleComplaintVO simpleComplaintVO) {
		return this.loadComplaintFromSimpleComplaintVO(simpleComplaintVO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void toComplaintVO(Complaint source, ComplaintVO target) {
		// TODO verify behavior of toComplaintVO
		super.toComplaintVO(source, target);

		if(source.getSubject() != null){
			target.setSubject(source.getSubject().getName());
			target.setSubjectId(source.getSubject().getId());
		}else{
			target.setSubject("");
			target.setSubjectId(null);
		}
		
		if(source.getType() != null){
			target.setType(source.getType().getName());
			target.setTypeId(source.getType().getId());
		}else{
			target.setType("");
			target.setTypeId(null);
		}
		
		if(source.getDemandant() != null){
			target.setDemandant(getDemandantDao().toDemandantVO(source.getDemandant()));
		}
		
		target.setDate(source.getDate());
		
		List<AnswerVO> answers = (List<AnswerVO>) getAnswerDao().findByComplaintId(AnswerDao.TRANSFORM_ANSWERVO, source.getId());
		if(answers == null){
			answers = new ArrayList<AnswerVO>();
		}
		target.setAnswers(answers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ComplaintVO toComplaintVO(final Complaint entity) {
		return super.toComplaintVO(entity);
	}

	/**
	 * Retrieves the entity object that is associated with the specified value
	 * object from the object store. If no such entity object exists in the
	 * object store, a new, blank entity is created
	 */
	private Complaint loadComplaintFromComplaintVO(ComplaintVO vo) {
		Complaint retorno = null;
		if (vo.getId() == null) {
			retorno = Complaint.Factory.newInstance();
		} else {
			retorno = load(vo.getId());
		}
		return retorno;
	}

	/**
	 * {@inheritDoc}
	 */
	public Complaint complaintVOToEntity(ComplaintVO complaintVO) {
		Complaint entity = this.loadComplaintFromComplaintVO(complaintVO);
		this.complaintVOToEntity(complaintVO, entity, true);
		return entity;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void complaintVOToEntity(ComplaintVO source, Complaint target,
			boolean copyIfNull) {
		super.complaintVOToEntity(source, target, copyIfNull);

		if (copyIfNull || source.getAnswerType() != null) {
			target.setAnswerWay(source.getAnswerType());
		}

		if (copyIfNull || source.getDate() != null) {
			target.setDate(source.getDate());
		}

		if (source.getDemandant() != null
				&& source.getDemandant().getId() != null) {
			target.setDemandant(getDemandantDao().load(
					source.getDemandant().getId()));
		}

		if (copyIfNull || source.getSubjectId() != null) {
			target.setSubject(getSubjectDao().load(source.getSubjectId()));
		}

		if (copyIfNull || source.getTypeId() != null) {
			target.setType(getComplaintTypeDao().load(source.getTypeId()));
		}
	}

	@Override
	public Complaint resumedComplaintVOToEntity(
			ResumedComplaintVO resumedComplaintVO) {
		return load(resumedComplaintVO.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void toResumedComplaintVO(Complaint source, ResumedComplaintVO target) {
		target.setId(source.getId());
		target.setDate(source.getDate().toString());
		target.setStatus(source.getStatus().getValue());
		target.setSubject((source.getSubject() == null) ? "" : source.getSubject().getName());
		target.setType((source.getType() == null) ? "" : source.getType().getName());
	}
}