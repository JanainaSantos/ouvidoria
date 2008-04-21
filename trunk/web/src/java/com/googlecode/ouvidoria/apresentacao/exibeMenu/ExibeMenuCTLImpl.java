// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.exibeMenu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

/**
 * @see com.googlecode.ouvidoria.apresentacao.exibeMenu.ExibeMenuCTL
 */
public class ExibeMenuCTLImpl extends ExibeMenuCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.exibeMenu.ExibeMenuCTL#encerraSessaoUsuario(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.exibeMenu.EncerraSessaoUsuarioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void encerraSessaoUsuario(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.exibeMenu.EncerraSessaoUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	System.out.println("removendo usuario da sessao");
    	getGerenteSessaoUsuario(request).setUsuario(null);
    }

}