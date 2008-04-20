// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.negocio.usuario;

import com.googlecode.ouvidoria.negocio.usuario.vo.UsuarioVO;

/**
 * @see com.googlecode.ouvidoria.negocio.usuario.Usuario
 */
public class UsuarioDaoImpl extends com.googlecode.ouvidoria.negocio.usuario.UsuarioDaoBase {

	public UsuarioVO toUsuarioVO(Usuario entity) {
		UsuarioVO vo = new UsuarioVO();
		vo.setEmail(entity.getEmail());
		vo.setId(entity.getId());
		vo.setLogin(entity.getLogin());
		vo.setNome(entity.getNome());
		vo.setRamal(entity.getRamal());
		vo.setSenha(entity.getSenha());
		return vo;
	}

	public Usuario usuarioVOToEntity(UsuarioVO usuarioVO) {
		return load(usuarioVO.getId());
	}
}
