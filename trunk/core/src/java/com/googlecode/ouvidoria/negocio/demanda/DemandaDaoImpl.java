// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.googlecode.ouvidoria.negocio.demanda;

import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Query;

/**
 * @see com.googlecode.ouvidoria.negocio.demanda.Demanda
 */
public class DemandaDaoImpl extends com.googlecode.ouvidoria.negocio.demanda.DemandaDaoBase {

	@Override
	public java.util.Collection pesquisarDocumentos(final int transform, final com.googlecode.ouvidoria.negocio.demanda.DemandaCriteria criteria) {
		System.out.println("pesquisando demandas ...");
		mostrarCriteria(criteria);
		try {
			Query query = gerarQueryPesquisaDemanda(criteria);
			System.out.println("QUERY: " + query.getQueryString());
			java.util.List results = query.list();
			System.out.println("Resultado.length="+results.size());
			transformEntities(transform, results);
			return results;
		} catch (org.hibernate.HibernateException ex) {
			throw super.convertHibernateAccessException(ex);
		}
	}

	private void mostrarCriteria(com.googlecode.ouvidoria.negocio.demanda.DemandaCriteria criteria) {
		System.out.println("CRITERIA:");
		System.out.println("assunto" + criteria.getAssunto());
		System.out.println("dataInicio" + criteria.getDataInicio());
		System.out.println("dataFim" + criteria.getDataFim());
		System.out.println("formaDeContato=" + criteria.getFormaContato());
		System.out.println("tipoDemanda" + criteria.getTipoDemanda());
	}

	private org.hibernate.Query gerarQueryPesquisaDemanda(com.googlecode.ouvidoria.negocio.demanda.DemandaCriteria criteria) {
		StringBuffer hql = new StringBuffer("from com.googlecode.ouvidoria.negocio.demanda.DemandaImpl d ");
		ArrayList<String> termos = new ArrayList<String>();
		java.util.Hashtable param = new java.util.Hashtable();

		if (criteria.getAssunto() != null && criteria.getAssunto() > 0) {
			termos.add("d.assunto.id = :assunto");
			param.put("assunto", criteria.getAssunto());
			System.out.println("assunto" + criteria.getAssunto());
		}

		if (criteria.getDataInicio() != null) {
			if (criteria.getDataFim() != null) {
				termos.add("d.dataCriacao between :dataInicio and :dataFim");
				param.put("dataInicio", criteria.getDataInicio());
				param.put("dataFim", criteria.getDataFim());
				System.out.println("dataInicio" + criteria.getDataInicio());
				System.out.println("dataFim" + criteria.getDataFim());
			} else {
				termos.add("d.dataCriacao = :data");
				param.put("data", criteria.getDataInicio());
				System.out.println("data" + criteria.getDataInicio());
			}
		}

		if (criteria.getFormaContato() != null && criteria.getFormaContato() > 0) {
			termos.add("d.formaDeContato.id = :formaDeContato");
			param.put("formaDeContato", criteria.getFormaContato());
			System.out.println("formaDeContato=" + criteria.getFormaContato());
		}

		if (criteria.getTipoDemanda() != null && criteria.getTipoDemanda() > 0) {
			termos.add("d.tipoDemanda.id = :tipoDemanda");
			param.put("tipoDemanda", criteria.getTipoDemanda());
			System.out.println("tipoDemanda" + criteria.getTipoDemanda());
		}

		if (termos.size() > 0) {
			hql.append(" where ");
			hql.append(termos.get(0));
			for (int i = 1; i < termos.size(); i++) {
				hql.append(" and " + termos.get(i));
			}
		}

		System.out.println("HQL: " + hql.toString());

		org.hibernate.Query queryObject = super.getSession(false).createQuery(hql.toString());

		//TODO
		//queryObject.setFirstResult(criteria.getFirstResult());
		//queryObject.setFetchSize(criteria.getFetchSize());
		//queryObject.setMaxResults(criteria.getMaximumResultSize());

		Iterator it = param.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next().toString();
			System.out.println("parametro --> " + key + "=" + param.get(key));
			queryObject.setParameter(key, param.get(key));
		}

		System.out.println("query: " + queryObject.getQueryString());

		return queryObject;
	}
}
