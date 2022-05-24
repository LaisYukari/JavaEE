package br.com.senai.laistomita.application.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class LoginBean implements Serializable {
	
	private String nome;
	private String senha;
	
	@PostConstruct //ligação de informações quando o bean for chamado
	public void onCreate() {
		System.out.println("Bean criado");
	}
	
	@PreDestroy //execução do método antes do bean ser destruido
	public void onDestroy() {
		System.out.println("Bean destruído");
	}
	
	public String doLogin() { //acesso a pagina
		if("abc".equals(nome) && "123".equals(senha)) { //validação de senha e login
			return "despesas"; //Outcome
		}
		return null; //jsf recarrega a mesma página, ou seja, mentém a mesma página
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
