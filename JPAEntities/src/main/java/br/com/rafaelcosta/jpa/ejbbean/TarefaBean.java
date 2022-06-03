package br.com.rafaelcosta.jpa.ejbbean;
// bean da logica de negocio, com objeto, banco de dados
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.rafaelcosta.jpa.model.Tarefa;

@Stateless //tipo de bean
public class TarefaBean {

	@PersistenceContext //jpa faz por "trás"
	private EntityManager em; //classe jpa, conexao com o banco //em é a entidade gerenciadora
	
	public void inserir(Tarefa tarefa) { //recebimento de tarefa 
		em.persist(tarefa); //insere uma informação
	}
	
	public void atualizar(Tarefa tarefa) {
		em.merge(tarefa); //atualiza uma informação
	}
	
	public void excluir(Tarefa tarefa) {
		tarefa = carregar(tarefa.getId()); //procura e carrega a tarefa com o respectivo id
		em.remove(tarefa);
	}
	
	public Tarefa carregar(int id) { //id do objeto a ser carregado 
		return em.find(Tarefa.class, id); //procura através do id na tabela, retornando
	//está linkado com o banco de dados, caso contrário, se não estiver ligado, não será possivel remover, já que não será posssivel encontrar o id
	}
}


// html > jsf > ejb (binding) > banco de dados