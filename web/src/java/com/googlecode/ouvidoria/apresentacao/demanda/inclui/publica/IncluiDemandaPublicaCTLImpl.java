// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Assunto;
import com.googlecode.ouvidoria.negocio.demanda.Demanda;
import com.googlecode.ouvidoria.negocio.demanda.FormaContato;
import com.googlecode.ouvidoria.negocio.demanda.TipoDemanda;
import com.googlecode.ouvidoria.negocio.demandante.Cidade;
import com.googlecode.ouvidoria.negocio.demandante.Demandante;
import com.googlecode.ouvidoria.negocio.demandante.Estado;
import com.googlecode.ouvidoria.negocio.demandante.TipoDemandante;
import com.googlecode.ouvidoria.negocio.usuario.Usuario;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.IncluiDemandaPublicaCTL
 */
public class IncluiDemandaPublicaCTLImpl extends IncluiDemandaPublicaCTL {
	/**
	 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.IncluiDemandaPublicaCTL#preCadastraDemanda(org.apache.struts.action.ActionMapping,
	 *      com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PreCadastraDemandaForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void preCadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PreCadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {		
		Demanda demanda = Demanda.Factory.newInstance();
		
		//TODO como setar uma FormaContato padrao?? ler de um arquivo? 
		demanda.setFormaDeContato(FormaContato.Factory.newInstance());
		demanda.getFormaDeContato().setId(1L);	
		
		demanda.setAssunto(Assunto.Factory.newInstance());
		demanda.getAssunto().setId(form.getAssunto());
		
		demanda.setTipoDemanda(TipoDemanda.Factory.newInstance());
		demanda.getTipoDemanda().setId(form.getTipoDemanda());
		
		demanda.setMensagem(form.getMensagem());
				
		getGerenteSessaoDemanda(request).setDemanda(demanda);		
	}

	/**
	 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.IncluiDemandaPublicaCTL#populaTelaDemanda(org.apache.struts.action.ActionMapping,
	 *      com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandaForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void populaTelaDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		recuperaTiposDemanda(form);
		recuperaAssuntos(form);
	}

	private void recuperaTiposDemanda(com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandaForm form) throws Exception {
		HashMap mapa = new HashMap();		
		Iterator it = getDemandaService().recuperaTiposDemanda().iterator();
		while (it.hasNext()) {
			TipoDemanda tipo = (TipoDemanda) it.next();
			mapa.put(tipo.getId(), tipo.getNome());
		}
		form.setTipoDemandaValueList(mapa.keySet().toArray());
		form.setTipoDemandaLabelList(mapa.values().toArray());
	}

	private void recuperaAssuntos(com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandaForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandaService().recuperaAssuntos().iterator();
		while (it.hasNext()) {
			Assunto assunto = (Assunto) it.next();
			mapa.put(assunto.getId(), assunto.getNome());
		}
		form.setAssuntoValueList(mapa.keySet().toArray());
		form.setAssuntoLabelList(mapa.values().toArray());
	}

}
