// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.servico.usuario;

import com.googlecode.ouvidoria.negocio.usuario.Usuario;
import com.googlecode.ouvidoria.negocio.usuario.vo.UsuarioVO;

/**
 * @see com.googlecode.ouvidoria.servico.usuario.UsuarioService
 */
public class UsuarioServiceImpl extends com.googlecode.ouvidoria.servico.usuario.UsuarioServiceBase {

	/**
	 * @see com.googlecode.ouvidoria.servico.usuario.UsuarioService#autenticarUsuario(java.lang.String,
	 *      java.lang.String)
	 */
	protected com.googlecode.ouvidoria.negocio.usuario.vo.UsuarioVO handleAutenticarUsuario(java.lang.String login, java.lang.String senha) throws java.lang.Exception {
		UsuarioVO vo = null;
		Usuario usuario = getUsuarioDao().recuperaPorLogin(login);

		if (usuario != null && usuario.getSenha().equals(senha)) {
			vo = getUsuarioDao().toUsuarioVO(usuario);
		}

		return vo;
	}

}
