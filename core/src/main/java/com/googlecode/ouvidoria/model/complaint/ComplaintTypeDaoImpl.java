// Generated by hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge on 01/02/2015 08:34:18-0200.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.model.complaint;

import com.googlecode.ouvidoria.model.vo.SimpleVO;

/**
 * @see ComplaintType
 */
public class ComplaintTypeDaoImpl
    extends ComplaintTypeDaoBase
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void toSimpleVO(
        ComplaintType source,
        SimpleVO target)
    {
        // TODO verify behavior of toSimpleVO
        super.toSimpleVO(source, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimpleVO toSimpleVO(final ComplaintType entity)
    {
        // TODO verify behavior of toSimpleVO
        return super.toSimpleVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
        private ComplaintType loadComplaintTypeFromSimpleVO(SimpleVO vo)
    {
    	        ComplaintType retorno = null;
		if(vo.getId() == null){
			retorno = ComplaintType.Factory.newInstance();
		}else{
			retorno = load(vo.getId());
		}
		return retorno;	
		
        // TODO implement loadComplaintTypeFromSimpleVO
        //throw new UnsupportedOperationException("com.googlecode.ouvidoria.model.complaint.loadComplaintTypeFromSimpleVO(SimpleVO) not yet implemented.");

        /* A typical implementation looks like this:
        if (simpleVO.getId() == null)
        {
            return  ComplaintType.Factory.newInstance();
        }
        else
        {
            return this.load(simpleVO.getId());
        }
        */
    }

    /**
     * {@inheritDoc}
     */
    public ComplaintType simpleVOToEntity(SimpleVO simpleVO)
    {
        // TODO verify behavior of simpleVOToEntity
        ComplaintType entity = this.loadComplaintTypeFromSimpleVO(simpleVO);
        this.simpleVOToEntity(simpleVO, entity, true);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void simpleVOToEntity(
        SimpleVO source,
        ComplaintType target,
        boolean copyIfNull)
    {
        // TODO verify behavior of simpleVOToEntity
        super.simpleVOToEntity(source, target, copyIfNull);
    }
}