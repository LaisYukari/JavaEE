package br.com.senai.laistomita.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // diz que essa classe é uma entidade que será gravada no banco de dados, fazendo com que a jpa crie uma tabela dentro do banco de dados
public class Despesas {
	@Id//será primary key
	@GeneratedValue//gera automático	
	private Integer id; //atributo id para virar uma entidade na tabela //integer para não receber null
	private String data;
	private String descricao;
	private Double valor;
	private boolean edit;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public boolean getEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public Despesas(String data, String descricao, Double valor) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Despesas() {
		super();
	}
	
	
}
