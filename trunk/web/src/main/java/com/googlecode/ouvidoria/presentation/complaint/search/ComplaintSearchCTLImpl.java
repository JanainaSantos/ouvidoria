// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\ControllerImpl.java.vsl)
package com.googlecode.ouvidoria.presentation.complaint.search;

import java.util.List;

import com.googlecode.ouvidoria.model.complaint.enums.ComplaintStatus;
import com.googlecode.ouvidoria.model.complaint.vo.ComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.ResumedComplaintVO;
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
		System.out.println("populateScreen ............");
		
		ComplaintVO criteria = new ComplaintVO();
		
		if(form.getCode() != null){
			criteria.setId(form.getCode());
		}
		if(!StringUtils.isStringVazia(form.getComplaintStatus())){
			criteria.setStatus(ComplaintStatus.fromString(form.getComplaintStatus()));
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
		
		/*SortedSet<ResumedComplaintVO> complaints = new TreeSet<ResumedComplaintVO>();
		complaints.add(new ResumedComplaintVO(1L,"13/12/2014","type-01","status-01","subject-01"));
		complaints.add(new ResumedComplaintVO(2L,"13/12/2014","type-02","status-02","subject-02"));
		complaints.add(new ResumedComplaintVO(3L,"13/12/2014","type-03","status-03","subject-03"));
		complaints.add(new ResumedComplaintVO(4L,"13/12/2014","type-04","status-04","subject-04"));*/
		form.setComplaints(complaints);
	}

	@Override
	public void initializeComplaintId(InitializeComplaintIdForm form) throws Throwable {
		getComplaintSessionObject().setComplaintId(form.getId());
		form.setComplaintId(form.getId());
	}

}