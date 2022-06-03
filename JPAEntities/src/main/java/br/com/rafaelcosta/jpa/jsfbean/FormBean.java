package br.com.rafaelcosta.jpa.jsfbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rafaelcosta.jpa.ejbbean.TarefaBean;
import br.com.rafaelcosta.jpa.model.Tarefa;

@Named("form") 
@RequestScoped //requisição de acordo com o projeto
public class FormBean implements Serializable {
	
	@EJB //criação de variavel que recebe a tarefa bean
	private TarefaBean tarefaBean;

	@Inject //classe do ejb
	private FacesContext context; //pega todas as informações do formulario
	
	private UIComponent searchInputText; //classe do ejb
	
	private Integer tarefaId; //atributo comum
	
	private Tarefa tarefa;
	
	 //ajax é um java script express, onde pode pontuar cada elemento e não a página inteira, podendo renderizar apenas a linha escolhida 
	public void gravar(AjaxBehaviorEvent event) {  //recebimento de ajax, guardando dentro do Event, chamando a respectiva função 
		if(tarefa.getId()==null) {  //validação da tarefa, podendo chamar a outra função  //bidden 
			tarefaBean.inserir(tarefa); 
		}else {
			tarefaBean.atualizar(tarefa); //caso estiver no mesmo id, atualiza
		}		
	}
	
	public void pesquisar(AjaxBehaviorEvent event) { //recebe o event do ajax, no bean já está preenchido a tarefa 
		tarefa = tarefaBean.carregar(tarefaId);
		
		if(tarefa == null) {
			context.addMessage(searchInputText.getClientId(context), //context caso não exista a tarefa, captura de informação e guarda dentro dele   //context> mensagem> cliente> contexto
					new FacesMessage("Tarefa n�o encontrada")); //inputText
		}
		tarefaId = null;		
	}
	
	public void excluir(AjaxBehaviorEvent event) { //chama a tarefabean, null nas tarefas da tela
		tarefaBean.excluir(tarefa);
		tarefa = null;
	}
	public Tarefa getTarefa() { //getTarefa para criar tarefa, nova ao recarregar a página
		if(tarefa==null) { //se null, cria nova tarefa (verificação)
			tarefa = new Tarefa(); //se tarefa existir, retorna
		}
		return tarefa;
	}

	public UIComponent getSearchInputText() {
		return searchInputText;
	}

	public void setSearchInputText(UIComponent searchInputText) {
		this.searchInputText = searchInputText;
	}

	public Integer getTarefaId() {
		return tarefaId;
	}

	public void setTarefaId(Integer tarefaId) {
		this.tarefaId = tarefaId;
	}
	
	
	
}

//bean do jsf apenas repassa as informaões do ejb
