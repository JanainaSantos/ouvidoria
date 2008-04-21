// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Assunto;
import com.googlecode.ouvidoria.negocio.demanda.Demanda;
import com.googlecode.ouvidoria.negocio.demanda.TipoDemanda;
import com.googlecode.ouvidoria.negocio.demandante.Cidade;
import com.googlecode.ouvidoria.negocio.demandante.Demandante;
import com.googlecode.ouvidoria.negocio.demandante.Estado;
import com.googlecode.ouvidoria.negocio.demandante.TipoDemandante;

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
		//TODO como setar uma FormaContato padrao??
		Demanda demanda = Demanda.Factory.newInstance();
		demanda.setAssunto(Assunto.Factory.newInstance());
		demanda.getAssunto().setId(form.getAssunto());
		demanda.setTipoDemanda(TipoDemanda.Factory.newInstance());
		demanda.getTipoDemanda().setId(form.getTipoDemanda());
		demanda.setMensagem(form.getMensagem());
				
		getGerenteSessaoDemanda(request).setDemanda(demanda);
		
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setMensagem("mensagem-test");
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setAssunto(new Long((long) -704303915));
		form.setAssuntoValueList(new Object[] { "assunto-1", "assunto-2", "assunto-3", "assunto-4", "assunto-5" });
		form.setAssuntoLabelList(form.getAssuntoValueList());
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setTipoDemanda(new Long((long) 1375887778));
		form.setTipoDemandaValueList(new Object[] { "tipoDemanda-1", "tipoDemanda-2", "tipoDemanda-3", "tipoDemanda-4", "tipoDemanda-5" });
		form.setTipoDemandaLabelList(form.getTipoDemandaValueList());
	}

	/**
	 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.IncluiDemandaPublicaCTL#preCadastraDemandante(org.apache.struts.action.ActionMapping,
	 *      com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PreCadastraDemandanteForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void preCadastraDemandante(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PreCadastraDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Demandante demandante = Demandante.Factory.newInstance();
		demandante.setCep(form.getCep());
		demandante.setCidade(Cidade.Factory.newInstance());
		demandante.getCidade().setId(form.getCidade());
		demandante.setDocumento(form.getDocumento());//TODO formatar ... pesquisar antes de salvar (usar o q ja existe)
		demandante.setEmail(form.getEmail());
		demandante.setEndereco(form.getEndereco());
		demandante.setNome(form.getNome());
		demandante.setTelefone(form.getTelefone());
		demandante.setTipoDemandante(TipoDemandante.Factory.newInstance());
		demandante.getTipoDemandante().setId(form.getTipoDemandante());
		
		getGerenteSessaoDemanda(request).setDemandante(demandante);
		
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setNome("nome-test");
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setDocumento("documento-test");
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setEmail("email-test");
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setTelefone("telefone-test");
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setEstado(new Long((long) -1293665946));
		form.setEstadoValueList(new Object[] { "estado-1", "estado-2", "estado-3", "estado-4", "estado-5" });
		form.setEstadoLabelList(form.getEstadoValueList());
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setCidade(new Long((long) -1360636124));
		form.setCidadeValueList(new Object[] { "cidade-1", "cidade-2", "cidade-3", "cidade-4", "cidade-5" });
		form.setCidadeLabelList(form.getCidadeValueList());
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setEndereco("endereco-test");
		// this property receives a default value, just to have the application
		// running on dummy data
		form.setTipoDemandante(new Long((long) -2094969219));
		form.setTipoDemandanteValueList(new Object[] { "tipoDemandante-1", "tipoDemandante-2", "tipoDemandante-3", "tipoDemandante-4", "tipoDemandante-5" });
		form.setTipoDemandanteLabelList(form.getTipoDemandanteValueList());
	}

	/**
	 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.IncluiDemandaPublicaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping,
	 *      com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.CadastraDemandaForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// nothing to be done for this operation, there are no properties that
		// can be set
		Demanda demanda = getGerenteSessaoDemanda(request).getDemanda();
		Demandante demandante = getGerenteSessaoDemanda(request).getDemandante();
		//TODO criar  o demandante anonimo (padrao)
		
		System.out.println("CADASTRA_DEMANDA:");
		System.out.println("Demanda: "+demanda);
		System.out.println("Demandante: "+getGerenteSessaoDemanda(request).getDemandante());
		System.out.println("...");
		if(demanda != null && demandante != null){
			demanda.setDemandante(demandante);
			demanda = getDemandaService().cadastraDemanda(demanda);
		}
		
	}

	/**
	 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.IncluiDemandaPublicaCTL#populaTelaDemandante(org.apache.struts.action.ActionMapping,
	 *      com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandanteForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void populaTelaDemandante(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		recuperaEstados(form);
		recuperaTiposDemandantes(form);
		//TODO this property receives a default value, just to have the application
		// running on dummy data
		form.setCidade(new Long((long) -1360636124));
		form.setCidadeValueList(new Object[] { "cidade-1", "cidade-2", "cidade-3", "cidade-4", "cidade-5" });
		form.setCidadeLabelList(form.getCidadeValueList());
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

	private void recuperaTiposDemandantes(com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandanteForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandanteService().recuperarTiposDemandante().iterator();
		while (it.hasNext()) {
			TipoDemandante tipo = (TipoDemandante) it.next();
			mapa.put(tipo.getId(), tipo.getNome());
		}
		form.setTipoDemandanteValueList(mapa.keySet().toArray());
		form.setTipoDemandanteLabelList(mapa.values().toArray());
	}

	private void recuperaEstados(com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandanteForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandanteService().recuperarEstados().iterator();
		while (it.hasNext()) {
			Estado estado = (Estado) it.next();
			mapa.put(estado.getId(), estado.getUf());
		}
		form.setEstadoValueList(mapa.keySet().toArray());
		form.setEstadoLabelList(mapa.values().toArray());
	}

}
