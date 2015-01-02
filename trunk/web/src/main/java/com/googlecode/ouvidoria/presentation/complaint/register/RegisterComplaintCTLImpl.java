// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\ControllerImpl.java.vsl)
package com.googlecode.ouvidoria.presentation.complaint.register;

import static com.googlecode.ouvidoria.presentation.util.ComboboxUtil.*;
import static com.googlecode.ouvidoria.util.ReflectionUtils.getLong;
import static com.googlecode.ouvidoria.util.ReflectionUtils.getString;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.ouvidoria.model.complaint.enums.ComplaintStatus;
import com.googlecode.ouvidoria.model.complaint.enums.Contact;
import com.googlecode.ouvidoria.model.complaint.vo.ComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.SimpleComplaintVO;
import com.googlecode.ouvidoria.model.demandant.enums.Sex;
import com.googlecode.ouvidoria.model.demandant.vo.DemandantVO;
import com.googlecode.ouvidoria.model.vo.SimpleVO;

/**
 * @see com.googlecode.ouvidoria.presentation.complaint.internet.register.RegisterComplaintCTL
 */
public class RegisterComplaintCTLImpl extends RegisterComplaintCTL {
	private Log log = LogFactory.getLog(RegisterComplaintCTLImpl.class);

	/**
	 * The serial version UID of this class. Needed for serialization.
	 */
	private static final long serialVersionUID = 7465615235771425976L;

	/**
	 * @see com.googlecode.ouvidoria.presentation.complaint.internet.register.RegisterComplaintCTL#populateScreen(java.lang.Long
	 *      demandantType, java.lang.String name, java.lang.Long sex,
	 *      java.lang.Long identification, java.lang.String document,
	 *      java.lang.String businessPhone, java.lang.String celularPhone,
	 *      java.lang.String email, java.lang.String address, java.lang.String
	 *      zipCode, java.lang.Long state, java.lang.Long city, java.lang.Long
	 *      type, java.lang.Long subject, java.lang.Long answer,
	 *      java.lang.String text)
	 */
	@Override
	public void populateScreen(PopulateScreenForm form) {
		log.info("populateScreen ...");
		List<SimpleVO> demandantTypes = getDemandantHelper().getDemandantTypes();
		form.setDemandantTypeBackingList(toSelectItemCollection(demandantTypes));

		List<SimpleVO> identificationTypes = getDemandantHelper().getIdentificationTypes();
		form.setIdentificationBackingList(toSelectItemCollection(identificationTypes));

		List<SimpleVO> sexTypes = getDemandantHelper().getSexTypes();
		form.setSexBackingList(toSelectItemCollection(sexTypes, false));

		List<SimpleVO> complaintTypes = getComplaintHelper().getComplaintTypes();
		form.setTypeBackingList(toSelectItemCollection(complaintTypes));

		List<SimpleVO> contacts = getComplaintHelper().getContacts();
		form.setAnswerBackingList(toSelectItemCollection(contacts, false));

		List<SimpleVO> subjects = getComplaintHelper().getSubjects();
		form.setSubjectBackingList(toSelectItemCollection(subjects));

		List<SimpleVO> statesList = getLocalityService().listStates();
		form.setStateBackingList(toSelectItemCollection(statesList));
	}

	/**
	 * @see com.googlecode.ouvidoria.presentation.complaint.internet.register.RegisterComplaintCTL#registerComplaint(java.lang.Long
	 *      demandantType, java.lang.String name, java.lang.Long sex,
	 *      java.lang.Long identification, java.lang.String document,
	 *      java.lang.String businessPhone, java.lang.String celularPhone,
	 *      java.lang.String email, java.lang.String address, java.lang.String
	 *      zipCode, java.lang.Long state, java.lang.Long city, java.lang.Long
	 *      type, java.lang.Long subject, java.lang.Long answer,
	 *      java.lang.String text)
	 */
	@Override
	public void registerComplaint(RegisterComplaintForm form) {
		log.info("registerComplaint ...");
		try {
			ComplaintVO complaintVO = toComplaintVO(form);
			SimpleComplaintVO saved = getComplaintService().save(complaintVO);
			form.setCode(String.format("%05d", saved.getId()));
			form.setPassword(saved.getPassword());
		} catch (Exception e) {
			// TODO mostrar mensagem de erro
			e.printStackTrace();
			throw new RuntimeException("ERRO: "+e.getLocalizedMessage(), e);
		}
	}

	/**
	 * @see com.googlecode.ouvidoria.presentation.complaint.internet.register.RegisterComplaintCTL#validateComplaint(java.lang.Long
	 *      demandantType, java.lang.String name, java.lang.Long sex,
	 *      java.lang.Long identification, java.lang.String document,
	 *      java.lang.String businessPhone, java.lang.String celularPhone,
	 *      java.lang.String email, java.lang.String address, java.lang.String
	 *      zipCode, java.lang.Long state, java.lang.Long city, java.lang.Long
	 *      type, java.lang.Long subject, java.lang.Long answer,
	 *      java.lang.String text)
	 */
	@Override
	public boolean validateComplaint(ValidateComplaintForm form) {
		log.info("validateComplaint ...");
		try {
			ComplaintVO complaintVO = toComplaintVO(form);
			return getComplaintService().validate(complaintVO);
		} catch (Exception e) {
			// TODO mostrar mensagem de erro
			e.printStackTrace();
		}
		return false;
	}

	private ComplaintVO toComplaintVO(Object form) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, IntrospectionException {
		ComplaintVO vo = new ComplaintVO();

		String answer = getString(form, "answer");
		vo.setAnswerType((answer == null) ? Contact.SITE : Contact.fromString(answer));

		vo.setSubjectId(getLong(form, "subject"));
		vo.setTypeId(getLong(form, "type"));
		vo.setText(getString(form, "text"));

		vo.setDemandant(toDemandantVO(form));

		// default values for complaint creation
		vo.setStatus(ComplaintStatus.CREATED);
		vo.setContact(Contact.SITE);
		vo.setDate(new Date());
		vo.setPassword("");
		
		return vo;
	}

	private DemandantVO toDemandantVO(Object form) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IntrospectionException {
		DemandantVO vo = new DemandantVO();

		vo.setAddress(getString(form, "address"));
		vo.setBusinessPhone(getString(form, "businessPhone"));
		vo.setCelularPhone(getString(form, "celularPhone"));
		vo.setDocument(getString(form, "document"));
		vo.setEmail(getString(form, "email"));
		vo.setName(getString(form, "name"));
		vo.setZipCode(getString(form, "zipCode"));
		
		vo.setTypeId(getLong(form, "demandantType"));
		vo.setIdentificationId(getLong(form, "identification"));
		vo.setStateId(getLong(form, "state"));
		vo.setCityId(getLong(form, "city"));

		String sex = getString(form, "sex");
		vo.setSex((sex == null) ? null : Sex.fromString(sex));
		
		return vo;
	}

}