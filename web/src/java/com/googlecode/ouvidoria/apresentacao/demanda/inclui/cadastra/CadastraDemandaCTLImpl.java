// license-header java merge-point
package com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra;

import java.util.HashMap;
import java.util.Iterator;

import org.apache.struts.action.ActionMapping;

import com.googlecode.ouvidoria.negocio.demanda.Demanda;
import com.googlecode.ouvidoria.negocio.demandante.Cidade;
import com.googlecode.ouvidoria.negocio.demandante.Demandante;
import com.googlecode.ouvidoria.negocio.demandante.Estado;
import com.googlecode.ouvidoria.negocio.demandante.TipoDemandante;
import com.googlecode.ouvidoria.negocio.usuario.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.CadastraDemandaCTL
 */
public class CadastraDemandaCTLImpl extends CadastraDemandaCTL
{
    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.CadastraDemandaCTL#populaTelaDemandante(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PopulaTelaDemandanteForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void populaTelaDemandante(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PopulaTelaDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	recuperaEstados(form);
		recuperaCidades(form);
		recuperaTiposDemandantes(form);
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.CadastraDemandaCTL#preCadastraDemandante(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PreCadastraDemandanteForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void preCadastraDemandante(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PreCadastraDemandanteForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Demandante demandante = Demandante.Factory.newInstance();
		
    	//recupera dados do formulario
		demandante.setCep(form.getCep());
		demandante.setDocumento(form.getDocumento());//TODO formatar ... pesquisar antes de salvar (usar o q ja existe)
		demandante.setEmail(form.getEmail());
		demandante.setEndereco(form.getEndereco());
		demandante.setNome(form.getNome());
		demandante.setTelefone(form.getTelefone());
		
		demandante.setCidade(Cidade.Factory.newInstance());
		demandante.getCidade().setId(form.getCidade());
		System.out.println("cidade: "+form.getCidade());
				
		demandante.setTipoDemandante(TipoDemandante.Factory.newInstance());
		demandante.getTipoDemandante().setId(form.getTipoDemandante());
		System.out.println("tipo_demandante: "+form.getTipoDemandante());
		
		getGerenteSessaoDemanda(request).setDemandante(demandante);		
    }

    /**
     * @see com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.CadastraDemandaCTL#cadastraDemanda(org.apache.struts.action.ActionMapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.CadastraDemandaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final boolean cadastraDemanda(ActionMapping mapping, com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.CadastraDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	//recupera dados pre-cadastrados
    	Demanda demanda = getGerenteSessaoDemanda(request).getDemanda();
		Demandante demandante = getGerenteSessaoDemanda(request).getDemandante();
		
		//seta o usuario que esta criando a demanda
		demanda.setUsuarioCriacao(Usuario.Factory.newInstance());
		demanda.getUsuarioCriacao().setId(getGerenteSessaoUsuario(request).getUsuario().getId());
		
		//verifica se os objetos do pre-cadastro nao sao nulos
		if(demanda != null && demandante != null){
			demanda.setDemandante(demandante);
			demanda = getDemandaService().cadastraDemanda(demanda);
		}
		
		//limpa objetos do pre-cadastramento da sessao
		getGerenteSessaoDemanda(request).setDemanda(null);
		getGerenteSessaoDemanda(request).setDemandante(null);
		
		//coloca a demanda no request para ser mostrada na tela de confirmacao
		request.setAttribute("demanda", demanda);
		
		//vai sempre retornar true, pois se der algum problema sera lancada excecao
		return true;
    }
    
    private void recuperaTiposDemandantes(com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PopulaTelaDemandanteForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandanteService().recuperarTiposDemandante().iterator();
		while (it.hasNext()) {
			TipoDemandante tipo = (TipoDemandante) it.next();
			mapa.put(tipo.getId(), tipo.getNome());
		}
		form.setTipoDemandanteValueList(mapa.keySet().toArray());
		form.setTipoDemandanteLabelList(mapa.values().toArray());
	}

	private void recuperaEstados(com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PopulaTelaDemandanteForm form) throws Exception {
		HashMap mapa = new HashMap();
		Iterator it = getDemandanteService().recuperarEstados().iterator();
		while (it.hasNext()) {
			Estado estado = (Estado) it.next();
			mapa.put(estado.getId(), estado.getUf());
		}
		form.setEstadoValueList(mapa.keySet().toArray());
		form.setEstadoLabelList(mapa.values().toArray());
	}

	private void recuperaCidades(com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PopulaTelaDemandanteForm form) throws Exception {
		String uf = (String) form.getEstadoLabelList()[0];
		recuperaCidades(form, uf);
	}
	
	private void recuperaCidades(com.googlecode.ouvidoria.apresentacao.demanda.inclui.cadastra.PopulaTelaDemandanteForm form, String uf) throws Exception {		
		HashMap mapa = new HashMap();
		Iterator it = getDemandanteService().recuperarCidadesDoEstado(uf).iterator();
		while (it.hasNext()) {
			Cidade cidade = (Cidade) it.next();
			mapa.put(cidade.getId(), cidade.getNome());
		}
		form.setCidadeValueList(mapa.keySet().toArray());
		form.setCidadeLabelList(mapa.values().toArray());
	}

	@Override
	public boolean verificaPreCadastroDemanda(ActionMapping mapping, VerificaPreCadastroDemandaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//TODO
		System.out.println("verificaPreCadastroDemanda: "+request.getAttribute("demanda"));
		System.out.println("verificaPreCadastroDemanda: "+request.getSession().getAttribute("demanda"));
		return true;
	}

	@Override
	public void confirmaCadastramento(ActionMapping mapping, ConfirmaCadastramentoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Demanda demanda = (Demanda) request.getAttribute("demanda");
		form.setId(demanda.getId());
		form.setSenha(demanda.getSenhaAcompanhamento());
	}

}