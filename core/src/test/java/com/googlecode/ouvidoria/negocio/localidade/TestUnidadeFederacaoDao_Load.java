package com.googlecode.ouvidoria.negocio.localidade;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
( { "classpath:applicationContext.xml",
    "/applicationContext-testDataSource.xml" } )
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class TestUnidadeFederacaoDao_Load {
	private Long ID_PADRAO = new Long(1);
	
	@Autowired
    private UnidadeFederacaoDao unidadeFederacaoDao;
	
	@Before
	public void init(){
		System.err.println("init ...");
		//UnidadeFederacao uf1 = unidadeFederacaoDao.create("Distrito Federal", "DF");
		//System.err.println("UF criada: "+uf1);
		//ID_PADRAO = uf1.getId();
		System.err.println("ID_PADRAO="+ID_PADRAO);
	}
	
	@Test
	public void loadByIdValid(){
		System.err.println("TEST: loadByIdValid");
		System.err.println("ID_PADRAO="+ID_PADRAO);
		//UnidadeFederacao uf = unidadeFederacaoDao.load(ID_PADRAO);
		//System.err.println("UF="+uf);
	}
	
}
