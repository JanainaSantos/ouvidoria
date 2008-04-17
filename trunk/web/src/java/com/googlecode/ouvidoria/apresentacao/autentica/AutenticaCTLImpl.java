// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.autentica;

import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.autentica.AutenticaCTL
 */
public class AutenticaCTLImpl extends AutenticaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.autentica.AutenticaCTL#autenticaUsuario(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.autentica.AutenticaUsuarioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean autenticaUsuario(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.autentica.AutenticaUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setSenha("senha-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setLogin("login-test");
        return false;
    }

}