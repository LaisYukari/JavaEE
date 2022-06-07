package br.com.senai.laistomita.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinTable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity // diz que essa classe é uma entidade que será gravada no banco de dados, fazendo com que a JPA crie e inicialize uma tabela dentro do banco de dados

public class Despesas implements Serializable {
	
	@Id //será primary key
	@GeneratedValue//gerador automático	
	private Integer id; //atributo id para virar uma entidade na tabela //integer para não receber null
	private String data;
	private String descricao;
	private Double valor;
	private boolean edit;
	

	@ManyToMany(fetch = FetchType.EAGER) //manytomany cria um terceiro id
	@JoinTable(name = "despesas_produtos", 
		joinColumns = @JoinColumn(name = "despesas_id"),
		inverseJoinColumns = @JoinColumn(name = "produtos_idProduto"))
	private List<Despesas> despesas = new ArrayList<Despesas>();
	
	//Gerenciamento de novos atributos, e manipulação dos mesmos
	
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
	public Despesas() { //todas as Entities deve conter um construtor vazio
		super();
	}
	
	
}
