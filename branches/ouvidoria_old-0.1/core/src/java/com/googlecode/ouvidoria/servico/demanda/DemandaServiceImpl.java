// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.servico.demanda;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Random;

import com.googlecode.ouvidoria.negocio.demanda.Demanda;
import com.googlecode.ouvidoria.negocio.demanda.DemandaCriteria;
import com.googlecode.ouvidoria.negocio.demanda.HistoricoDemanda;
import com.googlecode.ouvidoria.negocio.demanda.StatusDemandaEnum;
import com.googlecode.ouvidoria.negocio.demandante.Demandante;

/**
 * @see com.googlecode.ouvidoria.servico.demanda.DemandaService
 */
public class DemandaServiceImpl
    extends com.googlecode.ouvidoria.servico.demanda.DemandaServiceBase
{
	
	@Override
	protected Demanda handleCadastraDemanda(Demanda demanda) throws Exception {		
		//gera uma senha de acompanhamento para a demanda
		//TODO externalizar o tamanho da senha
		demanda.setSenhaAcompanhamento(gerarSenhaAcompanhamentoDemanda(10));
		
		//seta data de criacao
		demanda.setDataCriacao(new Timestamp(System.currentTimeMillis()));			
		
		//recupera ou cadastra (caso ja exista) o demandante
		Demandante demandante = getDemandanteService().recuperarDemandantePorDocumento(demanda.getDemandante().getDocumento());
		if(demandante == null){
			demandante = getDemandanteService().cadastrarDemandante(demanda.getDemandante());
		}else {
			//se o demandante já existir atualiza seus dados
			demandante.setCep(demanda.getDemandante().getCep());
			demandante.setCidade(demanda.getDemandante().getCidade());
			demandante.setEmail(demanda.getDemandante().getEmail());
			demandante.setEndereco(demanda.getDemandante().getEndereco());
			demandante.setNome(demanda.getDemandante().getNome());
			demandante.setTelefone(demanda.getDemandante().getTelefone());
			demandante = getDemandanteService().atualizarDemandante(demandante);
		}
		demanda.setDemandante(demandante);
		
		//Seta status para EM_ANALISE
		HistoricoDemanda item = HistoricoDemanda.Factory.newInstance();
		item.setData(new Timestamp(System.currentTimeMillis()));
		item.setStatus(StatusDemandaEnum.EM_ANALISE);	
		
		//salva item do historico
		demanda.getHistorico().add(getHistoricoDemandaDao().create(item));
		
		//persiste a demanda
		return getDemandaDao().create(demanda);	
	}

	@Override
	protected Collection handleRecuperaAssuntos() throws Exception {
		return getAssuntoDao().loadAll();
	}

	@Override
	protected Collection handleRecuperaFormasContato() throws Exception {		
		return getFormaContatoDao().loadAll();
	}

	@Override
	protected Collection handleRecuperaTiposDemanda() throws Exception {		
		return getTipoDemandaDao().loadAll();
	}

	@Override
	protected Collection handlePesquisaDemandas(DemandaCriteria criteria) throws Exception {
		return getDemandaDao().pesquisarDemandas(criteria);
	}

	@Override
	protected Demanda handleConsultaDemanda(Long id, String senha) throws Exception {		
		return getDemandaDao().consultaDemanda(id, senha);
	}
	
	@Override
	protected String handleGerarSenhaAcompanhamentoDemanda(int tamanho) throws Exception {
		char[] alfabeto = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		StringBuffer senha = new StringBuffer();
		for(int i=0; i < tamanho; i++){
			senha.append(getRandomico(alfabeto));
		}
		return senha.toString();
	}

	//retorna um caracter randomico dentro do alfabeto passado como parametro
	private char getRandomico(char[] arr) {
		int indice = getRandomico(0, arr.length - 1);
		return arr[indice];
	}

	// este método utiliza da classe Random para retornar um inteiro randomico,dado um intervalo
	private int getRandomico(int start, int end) {
		Random generator = new Random();
		long range = (long) end - (long) start + 1;
		long fraction = (long) (range * generator.nextDouble());
		return ((int) (fraction + start));
	}

}