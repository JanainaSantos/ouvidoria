// Generated by hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge on 01/02/2015 08:34:18-0200.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.model.locality;

import com.googlecode.ouvidoria.model.vo.SimpleVO;

/**
 * @see City
 */
public class CityDaoImpl
    extends CityDaoBase
{
    /**
     * {@inheritDoc}
     */
    @Override
    public void toSimpleVO(
        City source,
        SimpleVO target)
    {
        // TODO verify behavior of toSimpleVO
        super.toSimpleVO(source, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SimpleVO toSimpleVO(final City entity)
    {
        // TODO verify behavior of toSimpleVO
        return super.toSimpleVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
        private City loadCityFromSimpleVO(SimpleVO vo)
    {
    	        City retorno = null;
		if(vo.getId() == null){
			retorno = City.Factory.newInstance();
		}else{
			retorno = load(vo.getId());
		}
		return retorno;	
		
        // TODO implement loadCityFromSimpleVO
        //throw new UnsupportedOperationException("com.googlecode.ouvidoria.model.locality.loadCityFromSimpleVO(SimpleVO) not yet implemented.");

        /* A typical implementation looks like this:
        if (simpleVO.getId() == null)
        {
            return  City.Factory.newInstance();
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
    public City simpleVOToEntity(SimpleVO simpleVO)
    {
        // TODO verify behavior of simpleVOToEntity
        City entity = this.loadCityFromSimpleVO(simpleVO);
        this.simpleVOToEntity(simpleVO, entity, true);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void simpleVOToEntity(
        SimpleVO source,
        City target,
        boolean copyIfNull)
    {
        // TODO verify behavior of simpleVOToEntity
        super.simpleVOToEntity(source, target, copyIfNull);
    }
}