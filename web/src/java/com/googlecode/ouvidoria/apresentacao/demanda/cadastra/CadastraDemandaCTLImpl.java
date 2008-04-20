// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.cadastra;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Assunto;
import com.googlecode.ouvidoria.negocio.demanda.TipoDemanda;
import com.googlecode.ouvidoria.negocio.demandante.Estado;
import com.googlecode.ouvidoria.negocio.demandante.TipoDemandante;
import com.googlecode.ouvidoria.negocio.usuario.vo.UsuarioVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL
 */
public class CadastraDemandaCTLImpl extends CadastraDemandaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#recuperaFormasContato(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaFormasContatoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaFormasContato(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaFormasContatoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setFormaContato(new Long((long)-2113222835));
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#recuperaTiposDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaTiposDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaTiposDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaTiposDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	HashMap mapa = new HashMap();
    	Iterator it = getDemandaService().recuperaTiposDemanda().iterator();
    	while(it.hasNext()){
    		TipoDemanda tipo = (TipoDemanda) it.next();
    		mapa.put(tipo.getId(), tipo.getNome());
    	}
        //form.setFormaContato(new Long((long)-2113222835));
        form.setTipoDemandaValueList(mapa.keySet().toArray());
        form.setTipoDemandaLabelList(mapa.values().toArray());   
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#recuperaAssuntos(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaAssuntosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaAssuntos(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaAssuntosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	HashMap mapa = new HashMap();
    	Iterator it = getDemandaService().recuperaAssuntos().iterator();
    	while(it.hasNext()){
    		Assunto assunto = (Assunto) it.next();
    		mapa.put(assunto.getId(), assunto.getNome());
    	}
        //form.setFormaContato(new Long((long)-2113222835));
        form.setAssuntoValueList(mapa.keySet().toArray());
        form.setAssuntoLabelList(mapa.values().toArray());  
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setNome("nome-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setDocumento("documento-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setEmail("email-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setTelefone("telefone-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setEstado(new Long((long)-1293665946));
        form.setEstadoValueList(new Object[] {"estado-1", "estado-2", "estado-3", "estado-4", "estado-5"});
        form.setEstadoLabelList(form.getEstadoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setCidade(new Long((long)-1360636124));
        form.setCidadeValueList(new Object[] {"cidade-1", "cidade-2", "cidade-3", "cidade-4", "cidade-5"});
        form.setCidadeLabelList(form.getCidadeValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setEndereco("endereco-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemandante(new Long((long)-2094969219));
        form.setTipoDemandanteValueList(new Object[] {"tipoDemandante-1", "tipoDemandante-2", "tipoDemandante-3", "tipoDemandante-4", "tipoDemandante-5"});
        form.setTipoDemandanteLabelList(form.getTipoDemandanteValueList());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#preCadastroDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.PreCadastroDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void preCadastroDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.PreCadastroDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        // this property receives a default value, just to have the application running on dummy data
        form.setMensagem("mensagem-test");
        // this property receives a default value, just to have the application running on dummy data
        form.setAssunto(new Long((long)-704303915));
        form.setAssuntoValueList(new Object[] {"assunto-1", "assunto-2", "assunto-3", "assunto-4", "assunto-5"});
        form.setAssuntoLabelList(form.getAssuntoValueList());
        // this property receives a default value, just to have the application running on dummy data
        form.setFormaContato(new Long((long)-2113222835));
        // this property receives a default value, just to have the application running on dummy data
        form.setTipoDemanda(new Long((long)1375887778));
        form.setTipoDemandaValueList(new Object[] {"tipoDemanda-1", "tipoDemanda-2", "tipoDemanda-3", "tipoDemanda-4", "tipoDemanda-5"});
        form.setTipoDemandaLabelList(form.getTipoDemandaValueList());
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#recuperaEstados(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaEstadosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaEstados(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaEstadosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	HashMap mapa = new HashMap();
    	Iterator it = getDemandanteService().recuperarEstados().iterator();
    	while(it.hasNext()){
    		Estado estado = (Estado) it.next();
    		mapa.put(estado.getId(), estado.getUf());
    	}
        //form.setFormaContato(new Long((long)-2113222835));
        form.setEstadoValueList(mapa.keySet().toArray());
        form.setEstadoLabelList(mapa.values().toArray()); 
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#recuperaTiposDemandante(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaTiposDemandanteForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaTiposDemandante(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaTiposDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	HashMap mapa = new HashMap();
    	Iterator it = getDemandanteService().recuperarTiposDemandante().iterator();
    	while(it.hasNext()){
    		TipoDemandante tipo = (TipoDemandante) it.next();
    		mapa.put(tipo.getId(), tipo.getNome());
    	}
        form.setTipoDemandanteValueList(mapa.keySet().toArray());
        form.setTipoDemandanteLabelList(mapa.values().toArray()); 
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#recuperaCidades(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaCidadesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperaCidades(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.RecuperaCidadesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//TODO
        // this property receives a default value, just to have the application running on dummy data
        form.setEstado(new Long((long)-1293665946));
        // this property receives a default value, just to have the application running on dummy data
        form.setCidade(new Long((long)-1360636124));
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.cadastra.CadastraDemandaCTL#verificaUsuario(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.VerificaUsuarioForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean verificaUsuario(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.cadastra.VerificaUsuarioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        boolean retorno = true;
    	UsuarioVO usr = getGerenteSessaoUsuario(request).getUsuario();
        if(usr == null)
        	retorno = false;
        return retorno;
    }

}