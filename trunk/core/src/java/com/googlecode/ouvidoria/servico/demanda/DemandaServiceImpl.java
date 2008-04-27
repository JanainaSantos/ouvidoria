// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.servico.demanda;

import java.sql.Timestamp;
import java.util.Collection;

import com.googlecode.ouvidoria.negocio.demanda.Demanda;
import com.googlecode.ouvidoria.negocio.demanda.DemandaCriteria;
import com.googlecode.ouvidoria.negocio.demanda.HistoricoDemanda;
import com.googlecode.ouvidoria.negocio.demanda.StatusDemandaEnum;
import com.googlecode.ouvidoria.negocio.demandante.Demandante;

/**
 * @see com.googlecode.ouvidoria.servico.demanda.DemandaService
 */
public class DemandaServiceImpl
    extends com.googlecode.ouvidoria.servico.demanda.DemandaServiceBase
{
	
	@Override
	protected Demanda handleCadastraDemanda(Demanda demanda) throws Exception {
		Demandante demandante = getDemandanteService().recuperarDemandantePorDocumento(demanda.getDemandante().getDocumento());
		if(demandante == null){
			demandante = getDemandanteService().cadastrarDemandante(demanda.getDemandante());
		}
		demanda.setDemandante(demandante);
		
		HistoricoDemanda item = HistoricoDemanda.Factory.newInstance();
		item.setData(new Timestamp(System.currentTimeMillis()));
		item.setStatus(StatusDemandaEnum.CRIADO);	
		
		demanda.getHistorico().add(getHistoricoDemandaDao().create(item));
		
		return getDemandaDao().create(demanda);	
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