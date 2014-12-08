// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::complaint::ComplaintHelper
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.complaint;

import com.googlecode.ouvidoria.model.complaint.ComplaintTypeDao;
import com.googlecode.ouvidoria.model.complaint.SubjectDao;
import com.googlecode.ouvidoria.model.complaint.enums.Contact;
import com.googlecode.ouvidoria.model.demandant.enums.Sex;
import com.googlecode.ouvidoria.model.vo.SimpleVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper
 */
public class ComplaintHelperImpl extends ComplaintHelperBase {

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper#getSubjects()
	 */
	@Override
	protected List<SimpleVO> handleGetSubjects() throws Exception {
		return (List<SimpleVO>) getSubjectDao().searchActive(SubjectDao.TRANSFORM_SIMPLEVO);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper#getComplaintTypes()
	 */
	@Override
	protected List<SimpleVO> handleGetComplaintTypes() throws Exception {
		return (List<SimpleVO>) getComplaintTypeDao().searchActive(ComplaintTypeDao.TRANSFORM_SIMPLEVO);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper#getContacts()
	 */
	@Override
	protected List<SimpleVO> handleGetContacts() throws Exception {
		List<SimpleVO> list = new ArrayList<>();
		for(Contact c: Contact.values()){
			list.add(new SimpleVO(null, c.getValue(), c.getValue(), true));
		}
		return list;
	}

}