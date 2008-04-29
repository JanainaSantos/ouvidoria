// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.pesquisa;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Assunto;
import com.googlecode.ouvidoria.negocio.demanda.DemandaCriteria;
import com.googlecode.ouvidoria.negocio.demanda.FormaContato;
import com.googlecode.ouvidoria.negocio.demanda.TipoDemanda;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.PesquisaDemandaCTL
 */
public class PesquisaDemandaCTLImpl extends PesquisaDemandaCTL {
	//TODO modelar esse atributo no magicDraw?
	public static final String SELECIONAR = "SELECIONE";

	/**
	 * This dummy variable is used to populate the "demandas" table. You may
	 * delete it when you add you own code in this controller.
	 */
	private static final java.util.Collection demandasDummyList = java.util.Arrays.asList(new Object[] { new DemandasDummy("tipoDemanda-1", "assunto-1", "dataCriacao-1"), new DemandasDummy("tipoDemanda-2", "assunto-2", "dataCriacao-2"),
			new DemandasDummy("tipoDemanda-3", "assunto-3", "dataCriacao-3"), new DemandasDummy("tipoDemanda-4", "assunto-4", "dataCriacao-4"), new DemandasDummy("tipoDemanda-5", "assunto-5", "dataCriacao-5") });

	/**
	 * This inner class is used in the dummy implementation in order to get the
	 * web application running without any manual programming. You may delete
	 * this class when you add you own code in this controller.
	 */
	public static final class DemandasDummy implements java.io.Serializable {
		private String tipoDemanda = null;
		private String assunto = null;
		private String dataCriacao = null;

		public DemandasDummy(String tipoDemanda, String assunto, String dataCriacao) {
			this.tipoDemanda = tipoDemanda;
			this.assunto = assunto;
			this.dataCriacao = dataCriacao;
		}

		public void setTipoDemanda(String tipoDemanda) {
			this.tipoDemanda = tipoDemanda;
		}

		public String getTipoDemanda() {
			return this.tipoDemanda;
		}

		public void setAssunto(String assunto) {
			this.assunto = assunto;
		}

		public String getAssunto() {
			return this.assunto;
		}

		public void setDataCriacao(String dataCriacao) {
			this.dataCriacao = dataCriacao;
		}

		public String getDataCriacao() {
			return this.dataCriacao;
		}

	}

	@Override
	public void recuperaDemandas(ActionMapping mapping, RecuperaDemandasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("recupera demandas ...........................................");

		DemandaCriteria criteria = new DemandaCriteria();
		criteria.setAssunto((form.getAssunto() == -1)?null:form.getAssunto());
		criteria.setDataFim(form.getDataFimAsDate());
		criteria.setDataInicio(form.getDataInicioAsDate());
		criteria.setFormaContato((form.getFormaContato() == -1)?null:form.getFormaContato());
		criteria.setTipoDemanda((form.getTipoDemanda() == -1)?null:form.getTipoDemanda());

		Collection demandas = getDemandaService().pesquisaDemandas(criteria);
		if (demandas != null)
			form.setDemandas(demandas);
	}

	@Override
	public void populaTelaPesquisa(ActionMapping mapping, PopulaTelaPesquisaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		recuperaAssuntos(form);
		recuperaFormasContato(form);
		recuperaTiposDemanda(form);
	}

	private void recuperaFormasContato(PopulaTelaPesquisaForm form) throws Exception {
		Object[] colecao = getDemandaService().recuperaFormasContato().toArray();
		Long[] valores = new Long[colecao.length+1];
		String[] labels = new String[colecao.length+1];
		
		valores[0] = new Long(-1);
		labels[0] = SELECIONAR;
		
		for(int i=0; i < colecao.length; i++){
			FormaContato forma = (FormaContato) colecao[i];
			valores[i+1] = forma.getId();
			labels[i+1] = forma.getNome();
		}

		form.setFormaContatoValueList(valores);
		form.setFormaContatoLabelList(labels);
	}

	private void recuperaTiposDemanda(PopulaTelaPesquisaForm form) throws Exception {
		Object[] colecao = getDemandaService().recuperaTiposDemanda().toArray();
		Long[] valores = new Long[colecao.length+1];
		String[] labels = new String[colecao.length+1];
		
		valores[0] = new Long(-1);
		labels[0] = SELECIONAR;
		
		for(int i=0; i < colecao.length; i++){
			TipoDemanda tipo = (TipoDemanda) colecao[i];
			valores[i+1] = tipo.getId();
			labels[i+1] = tipo.getNome();
		}

		form.setTipoDemandaValueList(valores);
		form.setTipoDemandaLabelList(labels);
	}

	private void recuperaAssuntos(PopulaTelaPesquisaForm form) throws Exception {
		Object[] colecao = getDemandaService().recuperaAssuntos().toArray();
		Long[] valores = new Long[colecao.length+1];
		String[] labels = new String[colecao.length+1];
		
		valores[0] = new Long(-1);
		labels[0] = SELECIONAR;
		
		for(int i=0; i < colecao.length; i++){
			Assunto assunto = (Assunto) colecao[i];
			valores[i+1] = assunto.getId();
			labels[i+1] = assunto.getNome();
		}

		form.setAssuntoValueList(valores);
		form.setAssuntoLabelList(labels);
	}
}
