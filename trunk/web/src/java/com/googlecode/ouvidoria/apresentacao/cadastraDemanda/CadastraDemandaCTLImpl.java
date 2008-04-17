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
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#recuperaFormasContato(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaFormasContatoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaFormasContato(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaFormasContatoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setFormaContato(new Long((long)-2113222835));
        form.setFormaContatoValueList(new Object[] {"formaContato-1", "formaContato-2", "formaContato-3", "formaContato-4", "formaContato-5"});
        form.setFormaContatoLabelList(form.getFormaContatoValueList());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#recuperaTiposDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaTiposDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaTiposDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaTiposDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemanda(new Long((long)1375887778));
        form.setTipoDemandaValueList(new Object[] {"tipoDemanda-1", "tipoDemanda-2", "tipoDemanda-3", "tipoDemanda-4", "tipoDemanda-5"});
        form.setTipoDemandaLabelList(form.getTipoDemandaValueList());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#recuperaAssuntos(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaAssuntosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaAssuntos(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.RecuperaAssuntosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setAssunto(new Long((long)-704303915));
        form.setAssuntoValueList(new Object[] {"assunto-1", "assunto-2", "assunto-3", "assunto-4", "assunto-5"});
        form.setAssuntoLabelList(form.getAssuntoValueList());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.cadastraDemanda.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setMensagem("mensagem-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setAssunto(new Long((long)-704303915));
        form.setAssuntoValueList(new Object[] {"assunto-1", "assunto-2", "assunto-3", "assunto-4", "assunto-5"});
        form.setAssuntoLabelList(form.getAssuntoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setFormaContato(new Long((long)-2113222835));
        form.setFormaContatoValueList(new Object[] {"formaContato-1", "formaContato-2", "formaContato-3", "formaContato-4", "formaContato-5"});
        form.setFormaContatoLabelList(form.getFormaContatoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemanda(new Long((long)1375887778));
        form.setTipoDemandaValueList(new Object[] {"tipoDemanda-1", "tipoDemanda-2", "tipoDemanda-3", "tipoDemanda-4", "tipoDemanda-5"});
        form.setTipoDemandaLabelList(form.getTipoDemandaValueList());
    }

}