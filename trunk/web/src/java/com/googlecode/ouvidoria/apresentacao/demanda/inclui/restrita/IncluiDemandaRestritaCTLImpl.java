// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Assunto;
import com.googlecode.ouvidoria.negocio.demanda.FormaContato;
import com.googlecode.ouvidoria.negocio.demanda.TipoDemanda;
import com.googlecode.ouvidoria.negocio.demandante.Estado;
import com.googlecode.ouvidoria.negocio.demandante.TipoDemandante;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.IncluiDemandaRestritaCTL
 */
public class IncluiDemandaRestritaCTLImpl extends IncluiDemandaRestritaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.IncluiDemandaRestritaCTL#preCadastraDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PreCadastraDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void preCadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PreCadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setMensagem("mensagem-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setAssunto(new Long((long)-704303915));
        form.setAssuntoValueList(new Object[] {"assunto-1", "assunto-2", "assunto-3", "assunto-4", "assunto-5"});
        form.setAssuntoLabelList(form.getAssuntoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setFormaContato(new Long((long)-2113222835));
        form.setFormaContatoValueList(new Object[] {"formaContato-1", "formaContato-2", "formaContato-3", "formaContato-4", "formaContato-5"});
        form.setFormaContatoLabelList(form.getFormaContatoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemanda(new Long((long)1375887778));
        form.setTipoDemandaValueList(new Object[] {"tipoDemanda-1", "tipoDemanda-2", "tipoDemanda-3", "tipoDemanda-4", "tipoDemanda-5"});
        form.setTipoDemandaLabelList(form.getTipoDemandaValueList());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.IncluiDemandaRestritaCTL#populaTelaDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void populaTelaDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	recuperaFormasContato(form);
    	recuperaTiposDemanda(form);
		recuperaAssuntos(form);
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.IncluiDemandaRestritaCTL#populaTelaDemandante(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandanteForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void populaTelaDemandante(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	recuperaEstados(form);
		recuperaTiposDemandantes(form);
        // TODO this property receives a default value, just to have the application running on dummy data
        form.setCidade(new Long((long)-1360636124));
        form.setCidadeValueList(new Object[] {"cidade-1", "cidade-2", "cidade-3", "cidade-4", "cidade-5"});
        form.setCidadeLabelList(form.getCidadeValueList());        
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.IncluiDemandaRestritaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.CadastraDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // nothing to be done for this operation, there are no properties that can be set
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.IncluiDemandaRestritaCTL#preCadastraDemandante(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PreCadastraDemandanteForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void preCadastraDemandante(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PreCadastraDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setNome("nome-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setDocumento("documento-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setEmail("email-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setTelefone("telefone-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setEstado(new Long((long)-1293665946));
        form.setEstadoValueList(new Object[] {"estado-1", "estado-2", "estado-3", "estado-4", "estado-5"});
        form.setEstadoLabelList(form.getEstadoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setCidade(new Long((long)-1360636124));
        form.setCidadeValueList(new Object[] {"cidade-1", "cidade-2", "cidade-3", "cidade-4", "cidade-5"});
        form.setCidadeLabelList(form.getCidadeValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEndereco("endereco-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemandante(new Long((long)-2094969219));
        form.setTipoDemandanteValueList(new Object[] {"tipoDemandante-1", "tipoDemandante-2", "tipoDemandante-3", "tipoDemandante-4", "tipoDemandante-5"});
        form.setTipoDemandanteLabelList(form.getTipoDemandanteValueList());
    }

    
    private void recuperaFormasContato(com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandaForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandaService().recuperaFormasContato().iterator();
		while (it.hasNext()) {
			FormaContato forma = (FormaContato) it.next();
			mapa.put(forma.getId(), forma.getNome());
		}
		form.setFormaContatoValueList(mapa.keySet().toArray());
		form.setFormaContatoLabelList(mapa.values().toArray());
	}
    
    private void recuperaTiposDemanda(com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandaForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandaService().recuperaTiposDemanda().iterator();
		while (it.hasNext()) {
			TipoDemanda tipo = (TipoDemanda) it.next();
			mapa.put(tipo.getId(), tipo.getNome());
		}
		form.setTipoDemandaValueList(mapa.keySet().toArray());
		form.setTipoDemandaLabelList(mapa.values().toArray());
	}

	private void recuperaAssuntos(com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandaForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandaService().recuperaAssuntos().iterator();
		while (it.hasNext()) {
			Assunto assunto = (Assunto) it.next();
			mapa.put(assunto.getId(), assunto.getNome());
		}
		form.setAssuntoValueList(mapa.keySet().toArray());
		form.setAssuntoLabelList(mapa.values().toArray());
	}

	private void recuperaTiposDemandantes(com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandanteForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandanteService().recuperarTiposDemandante().iterator();
		while (it.hasNext()) {
			TipoDemandante tipo = (TipoDemandante) it.next();
			mapa.put(tipo.getId(), tipo.getNome());
		}
		form.setTipoDemandanteValueList(mapa.keySet().toArray());
		form.setTipoDemandanteLabelList(mapa.values().toArray());
	}

	private void recuperaEstados(com.googlecode.ouvidoria.apresentacao.demanda.inclui.restrita.PopulaTelaDemandanteForm form) throws Exception {
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