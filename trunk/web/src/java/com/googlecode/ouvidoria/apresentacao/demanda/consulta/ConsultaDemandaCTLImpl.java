// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.consulta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Demanda;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.consulta.ConsultaDemandaCTL
 */
public class ConsultaDemandaCTLImpl extends ConsultaDemandaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.consulta.ConsultaDemandaCTL#consultaDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.consulta.ConsultaDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void consultaDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.consulta.ConsultaDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {    	
    	Long id = Long.parseLong(form.getCodigo());
    	String senha = form.getSenha();
    	
    	Demanda demanda = getDemandaService().consultaDemanda(id, senha);
        //TODO ...
    }

}