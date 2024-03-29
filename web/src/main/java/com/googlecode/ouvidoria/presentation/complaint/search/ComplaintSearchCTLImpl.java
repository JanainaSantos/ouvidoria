// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\ControllerImpl.java.vsl)
package com.googlecode.ouvidoria.presentation.complaint.search;

import static com.googlecode.ouvidoria.presentation.util.ComboboxUtil.toSelectItemCollection;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.ouvidoria.JsfUtils;
import com.googlecode.ouvidoria.model.complaint.enums.ComplaintStatus;
import com.googlecode.ouvidoria.model.complaint.vo.ComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.ResumedComplaintVO;
import com.googlecode.ouvidoria.model.vo.SimpleVO;
import com.googlecode.ouvidoria.util.StringUtils;

/**
 * @see com.googlecode.ouvidoria.presentation.complaint.search.ComplaintSearchCTL
 */
public class ComplaintSearchCTLImpl extends ComplaintSearchCTL {
	/**
	 * The serial version UID of this class. Needed for serialization.
	 */
	private static final long serialVersionUID = -5120859528350734637L;

	/**
	 * @see com.googlecode.ouvidoria.presentation.complaint.search.ComplaintSearchCTL#populateScreen(java.lang.Long
	 *      code, java.lang.String complaintStatus, java.lang.Long type,
	 *      java.lang.Long subject, java.lang.String text, java.lang.Long
	 *      demandantType, java.lang.String demandantName, java.lang.String
	 *      demandantDocument,
	 *      com.googlecode.ouvidoria.model.complaint.vo.ResumedComplaintVO
	 *      complaints)
	 */
	@Override
	public void populateScreen(PopulateScreenForm form) {
		List<SimpleVO> demandantTypes = getDemandantHelper().getDemandantTypes();
		form.setDemandantTypeBackingList(toSelectItemCollection(demandantTypes));

		List<SimpleVO> complaintStatus = getComplaintHelper().getComplaintStatus();
		form.setComplaintStatusBackingList(toSelectItemCollection(complaintStatus));
		
		List<SimpleVO> complaintTypes = getComplaintHelper().getComplaintTypes();
		form.setTypeBackingList(toSelectItemCollection(complaintTypes));

		List<SimpleVO> subjects = getComplaintHelper().getSubjects();
		form.setSubjectBackingList(toSelectItemCollection(subjects));
		
		if(!isFirst()){
			search(form);
		} else{
			form.setComplaints(new ArrayList<ResumedComplaintVO>());
		}
	}
	
	private void search(PopulateScreenForm form){
		ComplaintVO criteria = new ComplaintVO();
		
		if(form.getCode() != null){
			criteria.setId(form.getCode());
		}
		System.out.println(">>>>>>>>>>>>>>>>>>>>>> ********    form.getComplaintStatus()="+form.getComplaintStatus());
		if(!StringUtils.isStringVazia(form.getComplaintStatus())){
			criteria.setStatus(ComplaintStatus.fromString(form.getComplaintStatus()));
			System.out.println("********    STATUS="+criteria.getStatus());
		}
		if(form.getSubject() != null){
			criteria.setSubjectId(form.getSubject());
		}
		if(form.getType() != null){
			criteria.setTypeId(form.getType());
		}
		if(!StringUtils.isStringVazia(form.getText())){
			criteria.setText(form.getText().trim());
		}
		
		List<ResumedComplaintVO> complaints = getComplaintService().search(criteria);
		System.out.println("%%%%%%%%%%%%%%%%% complaints="+complaints.size());
		form.setComplaints(complaints);
	}

	@Override
	public void initializeComplaintId(InitializeComplaintIdForm form) throws Throwable {
		getComplaintSessionObject().setComplaintId(form.getId());
		form.setComplaintId(form.getId());
	}

	static final String FIRST = "_first_complaint_search_";
	//@Override
	public void startSearch() throws Throwable {
		System.out.println("********    startSearch .........................");
		setFirst(true);
	}
	
	private boolean isFirst(){
		boolean first = (Boolean) JsfUtils.getSessionAttribute(FIRST);
		System.out.println("********    isFirst="+first);
		if(first){
			setFirst(false);
		}
		return first;
	}

	private void setFirst(boolean first){
		System.out.println("********    setFirst="+first);
		JsfUtils.setSessionAttribute(FIRST, first);
	}
}