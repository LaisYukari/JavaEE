package Modelos;

public class Aluno {
	
	private String nome;
	private int cpf;
	private String curso;
	private Endereco endereco; // Foi colocado dessa forma porque o Endero possui v�rias informa��es espec�ficas dentro dele. "Um conjunto de Informa��es" "Nesse caso, o Endere�o � um tipo de dado".
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
		return "Aluno [nome=" + nome + ", cpf=" + cpf + ", curso=" + curso + ", endereco=" + endereco + "]";
	}
	
	
	
	
	

}
