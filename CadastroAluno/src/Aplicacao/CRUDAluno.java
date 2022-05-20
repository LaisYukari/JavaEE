package Aplicacao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Modelo.Aluno;
import Modelo.Endereco;

public class CRUDAluno {
	
	public static Aluno SalvarAluno(BufferedReader reader) {
		
	Aluno aluno = new Aluno();
	Endereco enderecoAluno = new Endereco();
	
	try {
	
	System.out.println("Dados do aluno");
	System.out.println("Nome do aluno: ");
		aluno.setNome(reader.readLine()); //readLine somente uma linha
	System.out.println("CPF: ");
		aluno.setCpf(Integer.parseInt(reader.readLine()));
	System.out.println("Curso: ");
		aluno.setCurso(reader.readLine());
		
	System.out.println("");
		
	System.out.println("Endereço");
	System.out.println("");
	System.out.println("Rua: ");
		enderecoAluno.setRua(reader.readLine());	
	System.out.println("Número: ");
		enderecoAluno.setNumero(Integer.parseInt(reader.readLine()));
	System.out.println("Bairro: ");
		enderecoAluno.setBairro(reader.readLine());
	System.out.println("CEP");
		enderecoAluno.setCep(Integer.parseInt(reader.readLine()));
	System.out.println("Cidade: ");
		enderecoAluno.setCidade(reader.readLine());
	System.out.println("Estado: ");
		enderecoAluno.setEstado(reader.readLine());
		
	aluno.setEndereco(enderecoAluno);
		
	BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroDeAluno.txt",true));
	PrintWriter pw = new PrintWriter(buffer); // Caminho para arquivos txt, buffer retorna uma string
	
	pw.println(aluno); //println pode receber objeto
	
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			return aluno;
		
	}

}
