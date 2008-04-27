// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.consulta;

import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        // this property receives a default value, just to have the application running on dummy data
        form.setSenha("senha-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setCodigo("codigo-test");
    }

}