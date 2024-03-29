// license-header java merge-point
//
// Generated by: EasyMockServiceImplTest.vsl in andromda-spring-cartridge.
//
package com.googlecode.ouvidoria.service.demandant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static org.easymock.EasyMock.*;
import com.googlecode.ouvidoria.service.demandant.AbstractDemandantServiceMockTest;


/**
* <p>
* Caso de Teste para <code>com.googlecode.ouvidoria.service.demandant.DemandantService</code>. 
* Sao criados 2 metodos de teste para cada metodo da classe de servico.
* Um dos metodos testa valores validos e o outro testa valores invalidos.
* </p>
*
* @see com.googlecode.ouvidoria.service.demandant.DemandantServiceImpl
*/
public class DemandantServiceImplMockTest extends AbstractDemandantServiceMockTest {

	//setup logging
	private Log log = LogFactory.getLog(DemandantServiceImplMockTest.class);

				
	/**
	* Metodo responsavel por testar o comportamento do metodo Save com valores validos.
	*
	* @see com.googlecode.ouvidoria.service.demandant.DemandantService#save(com.googlecode.ouvidoria.model.demandant.vo.DemandantVO)
	*/
	public void testSave() throws Exception {

		//exibe o nome do metodo de teste sendo executado
		log.info("Metodo: testSave()");
	
		/* setup data */
		/**
		* TODO aqui sao criados, caso necessario, os objetos necessarios para setar os metodos dos mocks
		*/

		/* setup mock */
		/**
		* TODO aqui vao as definicoes dos metodos dos mock que serao chamados. Tambem os expects sao declarados neste ponto.
		* Ex.: expect(this.objetoMock.metodoFake(param1, param2)).andReturn(ret);
		**/
		replayMocks();

		/**
		* TODO implementar a logica do teste
		*/
		//fail("Implementar a logica do teste");
	
		/* verifies mock */
		verifyMocks();
	}

	/**
	* Metodo responsavel por testar o comportamento do metodo Save com valores invalidos.

	* @see com.googlecode.ouvidoria.service.demandant.DemandantService#save(com.googlecode.ouvidoria.model.demandant.vo.DemandantVO)
	*/
	public void testSaveValoresInvalidos() throws Exception
	{

		//exibe o nome do metodo de teste sendo executado
		log.info("Metodo: testSaveValoresInvalidos()");
	
		/* setup data */
		/**
		* TODO aqui sao criados, caso necessario, os objetos necessarios para setar os metodos dos mocks
		*/

		/* setup mock */
		/**
		* TODO aqui vao as definicoes dos metodos dos mock que serao chamados. 
		* Tambem os expects sao declarados neste ponto.
		* Ex.: expect(this.objetoMock.metodoFake(param1, param2)).andReturn(ret);
		**/
		replayMocks();

		/**
		* TODO implementar a logica do teste
		*/
		//fail("Implementar a logica do teste");
	
		/* verifies mock */
		verifyMocks();
	}

} 