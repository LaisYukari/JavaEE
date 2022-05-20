package Aplicação;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Modelos.Aluno;
import Modelos.Endereco;

public class CRUDAluno {

	public static Aluno SalvarAluno(BufferedReader reader) {


		Aluno aluno =  new Aluno ();
		Endereco enderecoAluno = new Endereco();

		try {
			System.out.println("Dados do aluno: ");
			System.out.println("Nome: ");
			aluno.setNome(reader.readLine());
			System.out.println("CPF: ");
			aluno.setCpf(Integer.parseInt(reader.readLine()));
			System.out.println("Curso: ");
			aluno.setCurso(reader.readLine());
			System.out.println("Endereço: " );
			System.out.println("Rua: " );
			enderecoAluno.setRua(reader.readLine());
			System.out.println("Número: " );
			enderecoAluno.setNum(Integer.parseInt(reader.readLine()));
			System.out.println("Bairro: " );
			enderecoAluno.setBairro(reader.readLine());
			System.out.println("Cidade: " );
			enderecoAluno.setCidade(reader.readLine());
			System.out.println("Estado: " );
			enderecoAluno.setEstado(reader.readLine());
			System.out.println("CEP: " );
			enderecoAluno.setCep(Integer.parseInt(reader.readLine()));
			aluno.setEndereco(enderecoAluno);
			System.out.println("");



			try (BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroDeAluno.txt", true)); //Caminho para gravar arquivos em txt 
					PrintWriter pw = new PrintWriter(buffer)) {                                    //True para salvar um após o outro
				//Buffered não aceita objetos, então é preciso disso para aceitar objeto. Serve para escrita 
				pw.println(aluno);
			} //try força o fechamento do comando. Depois de executar, ao terminar ele fecha automaticamente

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aluno;

	}
	public static List<Aluno> ListarAlunosSalvos(int op) {
		List<Aluno> listaDeAlunos = new ArrayList<Aluno>(1);
		String line = "";

		try(BufferedReader reader = new BufferedReader(new FileReader("CadastroDeAluno.txt")))  { //Para ler. Neste caso, o arquivo txt, todas as informações que estão la.

			while((line = reader.readLine())!= null) { //transformar um objeto da lista em uma linha 
				//construtor como parametro 
				Aluno aluno = new Aluno(line);
				listaDeAlunos.add(aluno);

			}
		} catch  ( IOException e) {
			e.printStackTrace();
		} 

		if(op==0) {


			for(Aluno a: listaDeAlunos)
				System.out.println(a);
		}

		return listaDeAlunos;

	}

	
	public static void DeletarAluno(BufferedReader reader) throws NumberFormatException, IOException{
		List<Aluno> listaDealuno = ListarAlunosSalvos(1);

		for(int i=0; i<listaDealuno.size(); i++)
			System.out.println(i+" - " + listaDealuno.get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja deletar");
		int indice = Integer.parseInt(reader.readLine());

		listaDealuno.remove(indice);

		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroDeAluno.txt"));
				PrintWriter pw = new PrintWriter(buffer)){
			for (Aluno a:listaDealuno)
				pw.println(a);
		}
	}

	
	public static void EditarAluno (BufferedReader reader) throws NumberFormatException, IOException{
		List<Aluno> listaDealuno = ListarAlunosSalvos(1);

		for(int i=0;i<listaDealuno.size();i++)
			System.out.println(i+" - " + listaDealuno.get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja editar");
		int indice = Integer.parseInt(reader.readLine());

		Aluno aluno = listaDealuno.get(indice);
		Endereco enderecoAluno = aluno.getEndereco();

		System.out.println("Escolha o atributo que deseja alterar");
		System.out.println("1-Nome");
		System.out.println("2-CPF");
		System.out.println("3-Rua");
			

		int op = Integer.parseInt(reader.readLine());
		System.out.println("Escreva o novo valor do atributo");
		String edicao = reader.readLine();

		switch(op) {
		case 1: 
			aluno.setNome(edicao);
			break;
		case 2:
			aluno.setCpf(Integer.parseInt(edicao));
			break;
		case 3: 
			enderecoAluno.setRua(edicao);
			break;
		case 4:
			enderecoAluno.setRua(edicao);
			break;
		case 5:
			enderecoAluno.setNum(Integer.parseInt(edicao));
			break;
		case 6:
			enderecoAluno.setBairro(edicao);
			break;
		case 7:
			enderecoAluno.setCidade(edicao);
			break;
		case 8:
			enderecoAluno.setEstado(edicao);
			break;
		case 9:
			enderecoAluno.setCep(Integer.parseInt(edicao));
			break;
		}
		aluno.setEndereco(enderecoAluno);
		listaDealuno.set(indice, aluno);

		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroDeAluno.txt"));
				PrintWriter pw = new PrintWriter(buffer)){
			for (Aluno a:listaDealuno)
				pw.println(a);
			
		}
	}
}

