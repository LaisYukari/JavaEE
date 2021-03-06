package br.com.senai.laistomita.application.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.senai.laistomita.jpa.ejbbean.DespesaBean;
import br.com.senai.laistomita.model.Despesas;
@SuppressWarnings("serial") //tira o aviso de cuidado do Eclipse
@SessionScoped //tempo de vida dado a página, sendo assim o session deixa os dados ativos enquanto conectados ao navegador
@Named("tabela") // nome dado ao arquivo

public class TabelaBean implements Serializable{
	
	@EJB //chama a jpa automaticamente  //criação de variavel que recebe a tarefa bean
	private DespesaBean despesaBean;
	
	private Integer despesaId;
	
	private List<Despesas> despesas = new ArrayList<>();//recebe a lista chamada 'despesa' e grava na tabela
	
	String data;
	String descricao;
	Double valor;
	Boolean back = false;
			
		
	public String getData() {
			return data;
	}
	public void setData(String data) {
			this.data = data;
	}
	public String getDescricao() {
			return descricao;
	}
	public void setDescricao(String descricao) {
			this.descricao = descricao;
	}
	public Double getValor() {
			return valor;
	}
	public void setValor(Double valor) {
			this.valor = valor;
	}
	
	public Boolean getBack() {
		return back;
	}
	public void setBack(Boolean back) {
		this.back = back;
	}
	
	//cria novo objeto dentro da tabela 
	public String inserir(String data, String descricao, Double valor) {
		Despesas d = new Despesas(data, descricao, valor);
		d.setEdit(true);
		back = true;
		despesaBean.inserir(d);
		data = null;
		descricao = null;
		valor = null;
		return null;
	}
	
	//remove a despesa dentro da tabela
	public void excluir(Despesas despesa) {
		despesaBean.excluir(despesa);
		despesas = null;
	}
	
	//muda a forma que manipula a tabela
	public String editar(Despesas despesa) { 
		despesa.setEdit(true);
		return null;
	}
	
	//muda a forma que manipula a tabela
	public String gravar(Despesas despesa) { 
		despesa.setEdit(false);
		return null;
	}
	
	//mostra todas as depesas da tabela
	public List<Despesas> getDespesas(){
		return despesas;
	}
	
	
}
