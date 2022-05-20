package View;

import java.io.BufferedReader;
import java.io.IOException;


import Modelos.Produto;
import Util.ListaDeProdutos;

public class ViewCRUDProduto {
	
	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException { //opções do menu
		
		System.out.println("1- Cadastro de Produtos");
		System.out.println("2- Listar Produtos");
		System.out.println("3- Deletar Produto");
		System.out.println("4- Editar Produto");
		System.out.println("5- Sair");
		
		return Integer.parseInt(reader.readLine());		

	}
	
	public static String[] ViewSalvarproduto(BufferedReader reader) throws IOException { // metodo utilizado para salvar produto
	String[] menuProduto = {"Nome do Produto", "Categoria", "Marca", "Preço"};
	
	String[] cadastroProduto = {"", "", "", ""};
	
	for(int i=0; i<cadastroProduto.length; i++) { //length utilizado para retornar a quantidade de string
		System.out.println(menuProduto[i]);
		cadastroProduto[i] = reader.readLine();

	}
	return cadastroProduto;
}

	public static int ViewMenuListaIndexada (String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException { //metodo utilizado para a opção de deletar ou editar
		for(int i=0;i<ListaDeProdutos.getInstance().size();i++)
			System.out.println(i+" - " + ListaDeProdutos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do aluno que deseja "+ editar_deletar);

		return Integer.parseInt(reader.readLine());

	}
	
	public static String[] ViewOpcaoEditada(BufferedReader reader) throws IOException { //visualização de atributos possiveis para alteração
		String[] dadosEditados = {"",""};
		
		System.out.println("Escolha o atributo que deseja alterar");
		System.out.println("1-Nome");
		System.out.println("2-Categoria");
		System.out.println("3-Marca");
		System.out.println("4-Preço");
		
		dadosEditados[0] = ((BufferedReader) reader).readLine();
		System.out.println("Escreva o novo valor do atributo");
		dadosEditados[1] = ((BufferedReader) reader).readLine();

		return dadosEditados;	
}
	
	public static void ViewListaProdutoEditada() {
		
		for(Produto a: ListaDeProdutos.getInstance()) {
			System.out.println("----Produto----");
			System.out.println("Nome: " + a.getNome());
			System.out.println("Categoria: " + a.getCategoria());
			System.out.println("Marca: " + a.getMarca().getNomeMarca());
			System.out.println("Preço: $ " + a.getMarca().getPreco());
			System.out.println("---------------");
					
		}
			
		}
	
	public static void ViewMsgFinal(int op) { //mensagem final correspondente a cadaopção do menu

		String[] MsgFinal = {"Produto salvo com sucesso!",
							"Produto editado com sucesso",
							"Produto deletado com sucesso!",
							"Fim do programa!"};

		System.out.println(MsgFinal[op]);
	}

	
	}

//getinstance utilizado para retornar a instancia e fazer assim, uma possivel comparação
//menu
//return utilizado para opções no menu