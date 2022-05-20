package Aplicação;
//manipulação do objeto

import java.io.BufferedReader;



import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;



import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;
import View.ViewCRUDProduto;


public class CRUDProduto {

	public static void SalvarProduto(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException { //Objeto criado sem utilizar o "new", e sim o static.
		//utilizado para salvar produto
		Produto produto = new Produto();
		Marca marca = new Marca();

		String[] cadastroProduto = ViewCRUDProduto.ViewSalvarproduto(reader);

		produto.setNome(cadastroProduto[0]);
		produto.setCategoria(cadastroProduto[1]);
		marca.setNomeMarca(cadastroProduto[2]);
		marca.setPreco(Float.parseFloat(cadastroProduto[3]));
		produto.setMarca(marca);

		ListaDeProdutos.getInstance().add(produto);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

		ViewCRUDProduto.ViewMsgFinal(0);

	}
	public static void ListarProdutosSalvos() throws IOException {
		//metodo utilizado para carregar lista dos produtos salvos

		ListaDeProdutos.getInstance().clear();
		ManipulacaoArquivoTXT.LerArquivoTXT();
		ViewCRUDProduto.ViewListaProdutoEditada();

	}

	public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{
		//metodo para deletar infomações

		int indice = ViewCRUDProduto.ViewMenuListaIndexada("deletar", reader);

		ListaDeProdutos.getInstance().remove(indice);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

		ViewCRUDProduto.ViewMsgFinal(2);

	}



	public static void EditarProduto (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException{
		//metodo utilizado para editar as informações dos produto


		int indice = ViewCRUDProduto.ViewMenuListaIndexada("editar",reader);
		String[] dadosEditados = {"",""};
		Produto produto = ListaDeProdutos.getInstance().get(indice);

		dadosEditados = ViewCRUDProduto.ViewOpcaoEditada(reader);


		switch(Integer.parseInt(dadosEditados[0])) {
		case 1: 
			produto.setNome(dadosEditados[1]);
			break;
		case 2:
			produto.setCategoria(dadosEditados[1]);
			break;
		case 3: 
			produto.getMarca().setNomeMarca(dadosEditados[1]);
			break;
		case 4:
			produto.getMarca().setPreco(Float.parseFloat(dadosEditados[1]));
			break;

		}

		ListaDeProdutos.getInstance().set(indice, produto);


		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ViewCRUDProduto.ViewMsgFinal(3);


	}
}

//True para salvar um após o outro
//Caminho para gravar arquivos em txt 

//Buffered não aceita objetos, então é preciso disso para aceitar objeto. Serve para escrita 

//try força o fechamento do comando. Depois de executar, ao terminar ele fecha automaticamente
//txt é um arquivo permanente 

