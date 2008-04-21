// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.inclui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.usuario.vo.UsuarioVO;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.IncluiDemandaCTL
 */
public class IncluiDemandaCTLImpl extends IncluiDemandaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.IncluiDemandaCTL#verificaUsuario(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.VerificaUsuarioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean verificaUsuario(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.VerificaUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	boolean retorno = false;
        UsuarioVO usr = getGerenteSessaoUsuario(request).getUsuario();
        if(usr != null){
        	retorno = true;
        	//TODO deixa assim por enquanto ... mas fazer com acegi depois
        }
        
        return retorno;
    }

}