// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.cadastraDemanda;

import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Assunto;
import com.googlecode.ouvidoria.negocio.demanda.FormaContato;
import com.googlecode.ouvidoria.negocio.demanda.TipoDemanda;
import com.googlecode.ouvidoria.negocio.demandante.Estado;

/**
 * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL
 */
public class CadastraDemandaCTLImpl extends CadastraDemandaCTL
{
	  /**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//TODO 
        
    }

	@Override
	public void preCadastroDemanda(ActionMapping mapping, PreCadastroDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#recuperaFormasContato(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaFormasContatoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaFormasContato(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaFormasContatoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {    	
    	HashMap mapa = new HashMap();
    	Iterator it = getDemandaService().recuperaFormasContato().iterator();
    	while(it.hasNext()){
    		FormaContato forma = (FormaContato) it.next();
    		mapa.put(forma.getId(), forma.getNome());
    	}
        //form.setFormaContato(new Long((long)-2113222835));
        form.setFormaContatoValueList(mapa.keySet().toArray());
        form.setFormaContatoLabelList(mapa.values().toArray());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#recuperaTiposDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaTiposDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaTiposDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaTiposDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#recuperaAssuntos(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaAssuntosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaAssuntos(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaAssuntosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
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

  

	@Override
	public void recuperaCidades(ActionMapping mapping, RecuperaCidadesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recuperaEstados(ActionMapping mapping, RecuperaEstadosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {		
		HashMap mapa = new HashMap();
    	Iterator it = getDemandanteService().recuperarEstados().iterator();
    	while(it.hasNext()){
    		Estado estado = (Estado) it.next();
    		mapa.put(estado.getId(), estado.getUf());
    	}
        //form.setFormaContato(new Long((long)-2113222835));
        form.setEstadoValueList(mapa.keySet().toArray());
        form.setEstadoLabelList(mapa.values().toArray()); 
	}

	@Override
	public void recuperaTiposDemandante(ActionMapping mapping, RecuperaTiposDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	}

}