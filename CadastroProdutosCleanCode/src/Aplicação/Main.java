package Aplicação;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import View.ViewCRUDProduto;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//leituras de dados inseridos pelo usuário

		int menu = 0;
		while (menu != 5) {

			menu = ViewCRUDProduto.ViewMenuPrincipal(reader);
			//carregar opções do menu principal 


			switch (menu) {
			case 1:

				CRUDProduto.SalvarProduto(reader);
				break;

			case 2:
				CRUDProduto.ListarProdutosSalvos();
				break;

			case 3:
				CRUDProduto.DeletarProduto(reader);
				break;

			case 4:
				CRUDProduto.EditarProduto(reader);
				break;

			case 5:
				ViewCRUDProduto.ViewMsgFinal(3);
				break;

			}
		}
	}
}

/*charAt para ler apenas um caractere, 0 para ler o primeiro caractere. 
Se alguêm digitar mais de um caractere ele pega apenas o primeiro caractere*/
//readLine lê a linha toda.

//Criar espaço de armazenamento, para ler as informações.
/* Lista para guardar as informações, banco de dados. 
ArrayList quantos espaços precisar (construtor especial) */