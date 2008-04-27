// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.servico.demandante;

import com.googlecode.ouvidoria.negocio.demandante.Demandante;

/**
 * @see com.googlecode.ouvidoria.servico.demandante.DemandanteService
 */
public class DemandanteServiceImpl
    extends com.googlecode.ouvidoria.servico.demandante.DemandanteServiceBase
{

    /**
     * @see com.googlecode.ouvidoria.servico.demandante.DemandanteService#cadastrarDemandante(com.googlecode.ouvidoria.negocio.demandante.Demandante)
     */
    protected com.googlecode.ouvidoria.negocio.demandante.Demandante handleCadastrarDemandante(com.googlecode.ouvidoria.negocio.demandante.Demandante demandante)
        throws java.lang.Exception
    {
    	return getDemandanteDao().create(demandante);      
    }

    /**
     * @see com.googlecode.ouvidoria.servico.demandante.DemandanteService#recuperarEstados()
     */
    protected java.util.Collection handleRecuperarEstados()
        throws java.lang.Exception
    {        
        return getEstadoDao().loadAll();
    }

    /**
     * @see com.googlecode.ouvidoria.servico.demandante.DemandanteService#recuperarCidadesDoEstado(java.lang.String)
     */
    protected java.util.Collection handleRecuperarCidadesDoEstado(java.lang.String uf)
        throws java.lang.Exception
    {        
        return getCidadeDao().recuperaCidadesPorEstado(uf);
    }

    /**
     * @see com.googlecode.ouvidoria.servico.demandante.DemandanteService#recuperarTiposDemandante()
     */
    protected java.util.Collection handleRecuperarTiposDemandante()
        throws java.lang.Exception
    {        
        return getTipoDemandanteDao().loadAll();
    }

	@Override
	protected Demandante handleRecuperarDemandantePorDocumento(String documento) throws Exception {		
		return getDemandanteDao().recuperaPorDocumento(documento);
	}

}