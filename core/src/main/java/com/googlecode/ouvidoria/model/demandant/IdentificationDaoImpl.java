// Generated by hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge on 01/02/2015 08:34:18-0200.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.model.demandant;

import com.googlecode.ouvidoria.model.vo.SimpleVO;

/**
 * @see Identification
 */
public class IdentificationDaoImpl
    extends IdentificationDaoBase
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void toSimpleVO(
        Identification source,
        SimpleVO target)
    {
        // TODO verify behavior of toSimpleVO
        super.toSimpleVO(source, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimpleVO toSimpleVO(final Identification entity)
    {
        // TODO verify behavior of toSimpleVO
        return super.toSimpleVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
        private Identification loadIdentificationFromSimpleVO(SimpleVO vo)
    {
    	        Identification retorno = null;
		if(vo.getId() == null){
			retorno = Identification.Factory.newInstance();
		}else{
			retorno = load(vo.getId());
		}
		return retorno;	
		
        // TODO implement loadIdentificationFromSimpleVO
        //throw new UnsupportedOperationException("com.googlecode.ouvidoria.model.demandant.loadIdentificationFromSimpleVO(SimpleVO) not yet implemented.");

        /* A typical implementation looks like this:
        if (simpleVO.getId() == null)
        {
            return  Identification.Factory.newInstance();
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
    public Identification simpleVOToEntity(SimpleVO simpleVO)
    {
        // TODO verify behavior of simpleVOToEntity
        Identification entity = this.loadIdentificationFromSimpleVO(simpleVO);
        this.simpleVOToEntity(simpleVO, entity, true);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void simpleVOToEntity(
        SimpleVO source,
        Identification target,
        boolean copyIfNull)
    {
        // TODO verify behavior of simpleVOToEntity
        super.simpleVOToEntity(source, target, copyIfNull);
    }
}