package br.com.senai.laisyukari.application;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.senai.laisyukari.model.Endereco;
import br.com.senai.laisyukari.model.Estado;
import br.com.senai.laisyukari.model.Interesse;
import br.com.senai.laisyukari.model.Pessoa;
import br.com.senai.laisyukari.model.Telefone;
import br.com.senai.laisyukari.util.InicializacaoConstante;

@SuppressWarnings("serial")
@SessionScoped
@Named("cadastro")

public class CadastroBean implements Serializable {
	
	private Pessoa pessoa;
	
	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
			pessoa.setEnderecoResidencial(new Endereco());
			pessoa.getEnderecoResidencial().setEstado(new Estado());
			pessoa.setEnderecoComercial(new Endereco());
			pessoa.getEnderecoComercial().setEstado(new Estado());
			pessoa.setTelefoneResidencial(new Telefone());
			pessoa.setTelefoneCelular(new Telefone());
			pessoa.setTelefoneComercial(new Telefone());
		}
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Estado> getEstados() {
		return InicializacaoConstante.ESTADOS;
	}
	
	public List<Interesse> getInteresses() {
		return InicializacaoConstante.INTERESSES;
	}

}
