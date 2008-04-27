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
		
		//TODO gerar senha de acompanhamento
		demanda.setSenhaAcompanhamento("123");
		
		//TODO como setar uma FormaContato padrao??
		demanda.setFormaDeContato(FormaContato.Factory.newInstance());
		demanda.getFormaDeContato().setId(1L);
		
		//TODO como setar um usuario padrao??
		demanda.setUsuarioCriacao(Usuario.Factory.newInstance());
		demanda.getUsuarioCriacao().setId(2L);		
		
		demanda.setAssunto(Assunto.Factory.newInstance());
		demanda.getAssunto().setId(form.getAssunto());
		
		demanda.setTipoDemanda(TipoDemanda.Factory.newInstance());
		demanda.getTipoDemanda().setId(form.getTipoDemanda());
		
		demanda.setMensagem(form.getMensagem());
				
		getGerenteSessaoDemanda(request).setDemanda(demanda);		
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
		demandante.setDocumento(form.getDocumento());//TODO formatar ... pesquisar antes de salvar (usar o q ja existe)
		demandante.setEmail(form.getEmail());
		demandante.setEndereco(form.getEndereco());
		demandante.setNome(form.getNome());
		demandante.setTelefone(form.getTelefone());
		
		demandante.setCidade(Cidade.Factory.newInstance());
		demandante.getCidade().setId(form.getCidade());
		System.out.println("cidade: "+form.getCidade());
				
		demandante.setTipoDemandante(TipoDemandante.Factory.newInstance());
		demandante.getTipoDemandante().setId(form.getTipoDemandante());
		System.out.println("tipo_demandante: "+form.getTipoDemandante());
		
		getGerenteSessaoDemanda(request).setDemandante(demandante);		
	}

	/**
	 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.IncluiDemandaPublicaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping,
	 *      com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.CadastraDemandaForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		recuperaCidades(form);
		recuperaTiposDemandantes(form);
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

	private void recuperaCidades(com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandanteForm form) throws Exception {
		String uf = (String) form.getEstadoLabelList()[0];
		recuperaCidades(form, uf);
	}
	
	private void recuperaCidades(com.googlecode.ouvidoria.apresentacao.demanda.inclui.publica.PopulaTelaDemandanteForm form, String uf) throws Exception {		
		HashMap mapa = new HashMap();
		Iterator it = getDemandanteService().recuperarCidadesDoEstado(uf).iterator();
		while (it.hasNext()) {
			Cidade cidade = (Cidade) it.next();
			mapa.put(cidade.getId(), cidade.getNome());
		}
		form.setCidadeValueList(mapa.keySet().toArray());
		form.setCidadeLabelList(mapa.values().toArray());
	}
}
