package br.com.senai.laistomita.jpa.ejbbean;
import java.util.List;

//bean da logica de negocio, com objeto, banco de dados
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.com.senai.laistomita.model.Despesas;

@Stateless //tipo de bean
public class DespesaBean {

	@PersistenceContext  //JPA manipula por "trás" e realiza a conexão com o banco de dados
	private EntityManager em; //classe jpa, conexao com o banco //em é a entidade gerenciadora
	
	public List<Despesas> listar() { //carrega todos os pedidos, listagem
		return em.createQuery("SELECT p FROM Pedido p", Despesas.class).getResultList();
	}
	
	
	public void excluir(Despesas despesas) {  
		despesas = carregar(despesas.getId());  
		em.remove(despesas);
	}
	
	public Despesas carregar(int id) { //procura através do id 
		return em.find(Despesas.class, id); 
//está linkado com o banco de dados, caso contrário, se não estiver ligado, não será possivel remover, já que não será posssivel encontrar o id
	}
	
	public void atualizar(Despesas despesas) { //atualiza uma informação
		em.merge(despesas); 
	}
	
	public void inserir(Despesas despesas) { //recebimento de tarefa 
		em.persist(despesas);//insere uma informação
	}
}
