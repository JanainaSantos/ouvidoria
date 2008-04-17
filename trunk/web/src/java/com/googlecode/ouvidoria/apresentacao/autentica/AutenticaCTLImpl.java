// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.autentica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.autentica.Usuario;

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
        boolean retorno = false;
        
        String login = form.getLogin();
        String senha = form.getSenha();
        
        System.out.println("Autenticando usuario: "+login);
        
        Usuario usr = getUsuarioService().autenticarUsuario(login, senha);
        if(usr != null){
        	getGerenteSessaoUsuario(request).setUsuario(usr);
        	retorno = true;
        }
        
        return retorno;
    }

}