// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: OuvidoriaModel::com.googlecode.ouvidoria::service::complaint::ComplaintService
 * STEREOTYPE:  Service
 */
package com.googlecode.ouvidoria.service.complaint;

import com.googlecode.ouvidoria.model.complaint.vo.ComplaintVO;
import com.googlecode.ouvidoria.model.complaint.vo.SimpleComplaintVO;
import java.util.List;

/**
 * @see com.googlecode.ouvidoria.service.complaint.ComplaintService
 */
public class ComplaintServiceImpl
    extends ComplaintServiceBase
{

    /**
     * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#save(ComplaintVO)
     */
    @Override
    protected  SimpleComplaintVO handleSave(ComplaintVO vo)
        throws Exception
    {
        // TODO implement protected  SimpleComplaintVO handleSave(ComplaintVO vo)
        //throw new UnsupportedOperationException("com.googlecode.ouvidoria.service.complaint.ComplaintService.handleSave(ComplaintVO vo) Not implemented!");
    	return new SimpleComplaintVO();
    }

    /**
     * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#checkStatus(Long, String)
     */
    @Override
    protected  ComplaintVO handleCheckStatus(Long id, String password)
        throws Exception
    {
        // TODO implement protected  ComplaintVO handleCheckStatus(Long id, String password)
        throw new UnsupportedOperationException("com.googlecode.ouvidoria.service.complaint.ComplaintService.handleCheckStatus(Long id, String password) Not implemented!");
    }

    /**
     * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#get(Long)
     */
    @Override
    protected  ComplaintVO handleGet(Long id)
        throws Exception
    {
        // TODO implement protected  ComplaintVO handleGet(Long id)
        throw new UnsupportedOperationException("com.googlecode.ouvidoria.service.complaint.ComplaintService.handleGet(Long id) Not implemented!");
    }

    /**
     * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#search(ComplaintVO)
     */
    @Override
    protected  List<ComplaintVO> handleSearch(ComplaintVO criteria)
        throws Exception
    {
        // TODO implement protected  List<ComplaintVO> handleSearch(ComplaintVO criteria)
        throw new UnsupportedOperationException("com.googlecode.ouvidoria.service.complaint.ComplaintService.handleSearch(ComplaintVO criteria) Not implemented!");
    }

    /**
     * @see com.googlecode.ouvidoria.service.complaint.ComplaintService#validate(ComplaintVO)
     */
    @Override
    protected  boolean handleValidate(ComplaintVO vo)
        throws Exception
    {
        // TODO implement protected  boolean handleValidate(ComplaintVO vo)
        throw new UnsupportedOperationException("com.googlecode.ouvidoria.service.complaint.ComplaintService.handleValidate(ComplaintVO vo) Not implemented!");
    }

}