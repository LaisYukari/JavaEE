package Aplicacao;

import Modelos.Aluno;
import Modelos.Endereco;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno AlunoMaria= new Aluno();
		Endereco enderecoMaria = new Endereco();
		
		AlunoMaria.setNome("Maria");
		AlunoMaria.setCurso("Culinária");
		AlunoMaria.setCpf(23651363);
		enderecoMaria.setRua("Guatemala");
		enderecoMaria.setNumero(131);
		enderecoMaria.setBairro("Canhema");
		enderecoMaria.setCidade("Diadema");
		enderecoMaria.setEstado("SP");
		enderecoMaria.setCep(222);
		AlunoMaria.setEndereco(enderecoMaria);
		
		

	}
}
