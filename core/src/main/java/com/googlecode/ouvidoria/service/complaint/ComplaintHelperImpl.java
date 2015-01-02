// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::complaint::ComplaintHelper
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.complaint;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import com.googlecode.ouvidoria.model.complaint.ComplaintTypeDao;
import com.googlecode.ouvidoria.model.complaint.SubjectDao;
import com.googlecode.ouvidoria.model.complaint.enums.ComplaintStatus;
import com.googlecode.ouvidoria.model.complaint.enums.Contact;
import com.googlecode.ouvidoria.model.vo.SimpleVO;

/**
 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper
 */
public class ComplaintHelperImpl extends ComplaintHelperBase {

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper#getSubjects()
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected List<SimpleVO> handleGetSubjects() throws Exception {
		return (List<SimpleVO>) getSubjectDao().searchActive(SubjectDao.TRANSFORM_SIMPLEVO);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper#getComplaintTypes()
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected List<SimpleVO> handleGetComplaintTypes() throws Exception {
		return (List<SimpleVO>) getComplaintTypeDao().searchActive(ComplaintTypeDao.TRANSFORM_SIMPLEVO);
	}

	/**
	 * @see com.googlecode.ouvidoria.service.complaint.ComplaintHelper#getContacts()
	 */
	@Override
	protected List<SimpleVO> handleGetContacts() throws Exception {
		/*List<SimpleVO> list = new ArrayList<>();
		for(Contact c: Contact.values()){
			list.add(new SimpleVO(null, c.getValue(), c.getValue(), true));
		}
		return list;*/
		return toSimpleVoList(Contact.class);
	}

	@Override
	protected List<SimpleVO> handleGetComplaintStatus() throws Exception {
		List<SimpleVO> list = new ArrayList<>();
		/*for(ComplaintStatus c: ComplaintStatus.values()){
			list.add(new SimpleVO(null, c.getValue(), c.getValue(), true));
		}*/
		//return list;
		return toSimpleVoList(ComplaintStatus.class);
	}

	private <E extends Enum <E>> List<SimpleVO> toSimpleVoList(Class<E> elemType) {
		List<SimpleVO> list = new ArrayList<>();
        for (E e : java.util.EnumSet.allOf(elemType)) {
        	list.add(new SimpleVO(null, e.toString(), e.toString(), true));
        }
        return list;
    }
}