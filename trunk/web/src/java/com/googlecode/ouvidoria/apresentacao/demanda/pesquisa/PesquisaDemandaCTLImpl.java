// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.pesquisa;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Assunto;
import com.googlecode.ouvidoria.negocio.demanda.TipoDemanda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.PesquisaDemandaCTL
 */
public class PesquisaDemandaCTLImpl extends PesquisaDemandaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.PesquisaDemandaCTL#recuperaTiposDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.RecuperaTiposDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaTiposDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.RecuperaTiposDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	HashMap mapa = new HashMap();
    	Iterator it = getDemandaService().recuperaTiposDemanda().iterator();
    	while(it.hasNext()){
    		TipoDemanda tipo = (TipoDemanda) it.next();
    		mapa.put(tipo.getId(), tipo.getNome());
    	}
        //form.setFormaContato(new Long((long)-2113222835));
        form.setTipoDemandaValueList(mapa.keySet().toArray());
        form.setTipoDemandaLabelList(mapa.values().toArray()); 
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.PesquisaDemandaCTL#recuperaAssuntos(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.RecuperaAssuntosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaAssuntos(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.pesquisa.RecuperaAssuntosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	HashMap mapa = new HashMap();
    	Iterator it = getDemandaService().recuperaAssuntos().iterator();
    	while(it.hasNext()){
    		Assunto assunto = (Assunto) it.next();
    		mapa.put(assunto.getId(), assunto.getNome());
    	}
        //form.setFormaContato(new Long((long)-2113222835));
        form.setAssuntoValueList(mapa.keySet().toArray());
        form.setAssuntoLabelList(mapa.values().toArray());
    }

    /**
     * This dummy variable is used to populate the "demandas" table.
     * You may delete it when you add you own code in this controller.
     */
    private static final java.util.Collection demandasDummyList =
        java.util.Arrays.asList( new Object[] {
            new DemandasDummy("tipoDemanda-1", "assunto-1", "dataCriacao-1"),
            new DemandasDummy("tipoDemanda-2", "assunto-2", "dataCriacao-2"),
            new DemandasDummy("tipoDemanda-3", "assunto-3", "dataCriacao-3"),
            new DemandasDummy("tipoDemanda-4", "assunto-4", "dataCriacao-4"),
            new DemandasDummy("tipoDemanda-5", "assunto-5", "dataCriacao-5")
        } );

    /**
     * This inner class is used in the dummy implementation in order to get the web application
     * running without any manual programming.
     * You may delete this class when you add you own code in this controller.
     */
    public static final class DemandasDummy implements java.io.Serializable
    {
        private String tipoDemanda = null;
        private String assunto = null;
        private String dataCriacao = null;

        public DemandasDummy(String tipoDemanda, String assunto, String dataCriacao)
        {
            this.tipoDemanda = tipoDemanda;
            this.assunto = assunto;
            this.dataCriacao = dataCriacao;
        }
        
        public void setTipoDemanda(String tipoDemanda)
        {
            this.tipoDemanda = tipoDemanda;
        }

        public String getTipoDemanda()
        {
            return this.tipoDemanda;
        }
        
        public void setAssunto(String assunto)
        {
            this.assunto = assunto;
        }

        public String getAssunto()
        {
            return this.assunto;
        }
        
        public void setDataCriacao(String dataCriacao)
        {
            this.dataCriacao = dataCriacao;
        }

        public String getDataCriacao()
        {
            return this.dataCriacao;
        }
        
    }

	@Override
	public void recuperaDemandas(ActionMapping mapping, RecuperaDemandasForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		
	}
}