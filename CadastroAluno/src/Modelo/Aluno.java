package Modelo;

public class Aluno {
	
	private String nome;
	private int cpf;
	private String curso;
	private Endereco endereco;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Aluno \n Nome:" + nome + "\n CPF:" + cpf + "\n Curso:" + curso + "\n Endereco:" + endereco + "\n";
	} 
	
	
		
	
}

