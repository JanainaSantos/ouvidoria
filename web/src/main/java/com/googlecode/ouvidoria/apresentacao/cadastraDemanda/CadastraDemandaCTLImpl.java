// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.cadastraDemanda;

import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL
 */
public class CadastraDemandaCTLImpl extends CadastraDemandaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#populaTela(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.PopulaTelaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void populaTela(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.PopulaTelaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	// this property receives a default value, just to have the application running on dummy data
        form.setDemandante("demandante-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setMensagem("mensagem-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setAssunto("assunto-test");
        form.setAssuntoValueList(new Object[] {"assunto-1", "assunto-2", "assunto-3", "assunto-4", "assunto-5"});
        form.setAssuntoLabelList(form.getAssuntoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEmail("email-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setCidade("cidade-test");
        form.setCidadeValueList(new Object[] {"cidade-1", "cidade-2", "cidade-3", "cidade-4", "cidade-5"});
        form.setCidadeLabelList(form.getCidadeValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEstado("estado-test");
        form.setEstadoValueList(new Object[] {"estado-1", "estado-2", "estado-3", "estado-4", "estado-5"});
        form.setEstadoLabelList(form.getEstadoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEndereco("endereco-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemanda("tipoDemanda-test");
        form.setTipoDemandaValueList(new Object[] {"tipoDemanda-1", "tipoDemanda-2", "tipoDemanda-3", "tipoDemanda-4", "tipoDemanda-5"});
        form.setTipoDemandaLabelList(form.getTipoDemandaValueList());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setDemandante("demandante-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setMensagem("mensagem-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setAssunto("assunto-test");
        form.setAssuntoValueList(new Object[] {"assunto-1", "assunto-2", "assunto-3", "assunto-4", "assunto-5"});
        form.setAssuntoLabelList(form.getAssuntoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEmail("email-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setCidade("cidade-test");
        form.setCidadeValueList(new Object[] {"cidade-1", "cidade-2", "cidade-3", "cidade-4", "cidade-5"});
        form.setCidadeLabelList(form.getCidadeValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEstado("estado-test");
        form.setEstadoValueList(new Object[] {"estado-1", "estado-2", "estado-3", "estado-4", "estado-5"});
        form.setEstadoLabelList(form.getEstadoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEndereco("endereco-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemanda("tipoDemanda-test");
        form.setTipoDemandaValueList(new Object[] {"tipoDemanda-1", "tipoDemanda-2", "tipoDemanda-3", "tipoDemanda-4", "tipoDemanda-5"});
        form.setTipoDemandaLabelList(form.getTipoDemandaValueList());
        return true;
    }

}