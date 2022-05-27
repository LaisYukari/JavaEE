package br.com.senai.laistomita.jpa.ejbbean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.senai.laistomita.model.Despesas;

@Stateless
public class DespesaBean {

	@PersistenceContext
	private EntityManager em;
	
	public void excluir(Despesas despesas) {
		despesas = carregar(despesas.getId()); 
		em.remove(despesas);
	}
	
	public Despesas carregar(int id) {
		return em.find(Despesas.class, id); 
	
	}
	
	public void atualizar(Despesas despesas) {
		em.merge(despesas);
	}
	
	public void inserir(Despesas despesas) { 
		em.persist(despesas);
	}
}
