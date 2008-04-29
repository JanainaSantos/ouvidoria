// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.exibeContato;

import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.exibeContato.ExibeContatoCTL
 */
public class ExibeContatoCTLImpl extends ExibeContatoCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.exibeContato.ExibeContatoCTL#getEndereco(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.exibeContato.GetEnderecoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String getEndereco(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.exibeContato.GetEnderecoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // nothing to be done for this operation, there are no properties that can be set    	
        return "casa";
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.exibeContato.ExibeContatoCTL#getTelefone(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.exibeContato.GetTelefoneForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String getTelefone(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.exibeContato.GetTelefoneForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // nothing to be done for this operation, there are no properties that can be set
        return "2261000";
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.exibeContato.ExibeContatoCTL#getEmail(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.exibeContato.GetEmailForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String getEmail(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.exibeContato.GetEmailForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // nothing to be done for this operation, there are no properties that can be set
        return "teste";
    }

}