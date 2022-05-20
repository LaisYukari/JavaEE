package Aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import Modelo.Aluno;


public class Main {
	
	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // informações guardadas e armazenadasm
		
		
		
		List<Aluno> listaAluno = new ArrayList<Aluno>(); //lista tipo banco de dados, construtor sem espaço específico(utilizado com tipagem)
		
		char menu = ' '; //tipo de dado de acordo com o 'menu'
		while(menu != 's') {
			
			System.out.println("Digite 'c' para cadasrar aluno ou 's' para sair");
			
		
			try {
				
			menu = reader.readLine().charAt(0); //charArt para ler apenas um caractere
				
				if (menu != 's') {
			
			listaAluno.add(CRUDAluno.SalvarAluno(reader)); //salva na lista de alunos
			
				for(Aluno a :listaAluno) // inserir novos nomes na lista para assim mostrá-los
			System.out.println(a);
			
				} else {
					System.out.println("Sistema encerrado");
				}
		
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
			}

		}

	}


