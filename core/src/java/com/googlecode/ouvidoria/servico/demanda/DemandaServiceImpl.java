// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.servico.demanda;

import java.util.Collection;

import com.googlecode.ouvidoria.negocio.demanda.Demanda;
import com.googlecode.ouvidoria.negocio.demanda.DemandaCriteria;

/**
 * @see com.googlecode.ouvidoria.servico.demanda.DemandaService
 */
public class DemandaServiceImpl
    extends com.googlecode.ouvidoria.servico.demanda.DemandaServiceBase
{

	//TODO matar a sequencia unica ... criar uma sequencia para cada tabela
	
	
	@Override
	protected Demanda handleCadastraDemanda(Demanda demanda) throws Exception {
		return getDemandaDao().create(demanda);	
//TODO salvar o historico tbm (CRIADO)
	}

	@Override
	protected Collection handleRecuperaAssuntos() throws Exception {
		return getAssuntoDao().loadAll();
	}

	@Override
	protected Collection handleRecuperaFormasContato() throws Exception {		
		return getFormaContatoDao().loadAll();
	}

	@Override
	protected Collection handleRecuperaTiposDemanda() throws Exception {		
		return getTipoDemandaDao().loadAll();
	}

	@Override
	protected Collection handlePesquisaDemandas(DemandaCriteria criteria) throws Exception {
		return getDemandaDao().pesquisarDocumentos(criteria);
	}

}