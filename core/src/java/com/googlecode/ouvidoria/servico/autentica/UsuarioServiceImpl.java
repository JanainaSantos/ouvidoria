// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.servico.autentica;

import com.googlecode.ouvidoria.negocio.autentica.Usuario;
import com.googlecode.ouvidoria.negocio.autentica.UsuarioImpl;

/**
 * @see com.googlecode.ouvidoria.servico.autentica.UsuarioService
 */
public class UsuarioServiceImpl
    extends com.googlecode.ouvidoria.servico.autentica.UsuarioServiceBase
{

    /**
     * @see com.googlecode.ouvidoria.servico.autentica.UsuarioService#autenticarUsuario(java.lang.String, java.lang.String)
     */
    protected com.googlecode.ouvidoria.negocio.autentica.Usuario handleAutenticarUsuario(java.lang.String login, java.lang.String senha)
        throws java.lang.Exception
    {
        //@todo implement protected com.googlecode.ouvidoria.negocio.autentica.Usuario handleAutenticarUsuario(java.lang.String login, java.lang.String senha)
    	//TODO
    	
    	Usuario retorno = null;
    	
    	if(login.equalsIgnoreCase("pedro")){
    		retorno = new UsuarioImpl();
    		retorno.setLogin(login);    		
    	}
    	
        return retorno;
    }

}