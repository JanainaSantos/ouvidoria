// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.visualiza;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Demanda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.visualiza.VisualizaDemandaCTL
 */
public class VisualizaDemandaCTLImpl extends VisualizaDemandaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.visualiza.VisualizaDemandaCTL#verificaParametro(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.visualiza.VerificaParametroForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void verificaParametro(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.visualiza.VerificaParametroForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // nothing to be done for this operation, there are no properties that can be set
    	Demanda demanda = (Demanda) request.getAttribute("demanda");
    	System.out.println("visualiza: "+demanda);
    	if(demanda == null){
    		//TODO cria uma demanda vazia ou lança excecao ou ... ???
    	}
    }

}