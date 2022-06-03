package br.com.rafaelcosta.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // diz que essa classe é uma entidade que será gravada no banco de dados, fazendo com que a jpa crie uma tabela dentro do banco de dados
public class Tarefa {

	@Id //será primary key
	@GeneratedValue //gera automático
	private Integer id; //atributo id para virar uma entidade na tabela //integer para não receber null
	
	private String descricao;
	
	private Integer prioridade;
	
	private Boolean concluida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getConcluida() {
		return concluida;
	}

	public void setConcluida(Boolean concluida) {
		this.concluida = concluida;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}	
	
	
	
}
