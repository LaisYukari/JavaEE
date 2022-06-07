package br.com.senai.laistomita.jpa.ejbbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.senai.laistomita.model.Produtos;

@Stateless
public class ProdutoBean {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Produtos> listar(){
		return em.createQuery("SELECT p FROM Despesa p", Produtos.class).getResultList();
		
	}

}
