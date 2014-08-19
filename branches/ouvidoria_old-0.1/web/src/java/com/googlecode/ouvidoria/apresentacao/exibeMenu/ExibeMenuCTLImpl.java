// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.exibeMenu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.usuario.vo.UsuarioVO;

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
    	
    	//invalida a sessao do usuario
    	HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
    }

	@Override
	public void verificaSessaoUsuario(ActionMapping mapping, VerificaSessaoUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String usr =request.getRemoteUser(); 
		if(usr != null){
			UsuarioVO usuario = getUsuarioService().buscarPorLogin(usr);
			getGerenteSessaoUsuario(request).setUsuario(usuario);
		}
	}

}