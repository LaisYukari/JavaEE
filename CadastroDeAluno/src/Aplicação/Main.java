package Aplica��o;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Modelos.Aluno;

public class Main {
	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader( new InputStreamReader(System.in)); // Criar espa�o de armazenamento, para ler as informa��es.
		List<Aluno> listaAluno = new ArrayList<Aluno>(); /* Lista para guardar as informa��es, banco de dados. 
															ArrayList quantos espa�os precisar (construtor especial) */
		int menu = 0;
		while (menu!= 5) {

			System.out.println("1-Cadastrar Aluno");
			System.out.println("2-Listar Aluno");
			System.out.println("3-Deletar Aluno");
			System.out.println("4-Editar Aluno");
			System.out.println("5-Sair");

			try {
				menu =Integer.parseInt(reader.readLine());  	/*charAt para ler apenas um caractere, 0 para ler o primeiro caractere. 
																Se algu�m digitar mais de um caractere ele pega apenas o primeiro caractere*/
				//readLine l� a linha toda.

				switch (menu) {
				case 1:
					listaAluno.add(CRUDAluno.SalvarAluno(reader)); //Adicionar na lista de alunos os dados cadastrados.
					break;

				case 2:
					CRUDAluno.ListarAlunosSalvos(0);
					break;

				case 3: 
					CRUDAluno.DeletarAluno(reader);
					break;
					
				case 4:
					CRUDAluno.EditarAluno(reader);
					break;


					//	for (Aluno a : listaAluno) //Para mostrar todos os dados cadastrados, atribuindo cada um por vez a variavel "a", at� que todos sejam mostrados. Objetos que est�o na memoria RAM
					//	System.out.println(a);

				}	

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}
}

//to do lida como tarefa; fazer posteriormente 
