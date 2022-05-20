package Modelo;


public class Endereco {
	
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private int cep;
	
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return " \n Rua:" + rua + "\n N�mero:" + numero + "\n Bairro:" + bairro + "\n Cidade:" + cidade + "\n Estado:"
				+ estado + "\n CEP:" + cep;
	}

}
