package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulacaoArquivoTXT {

	private static String nomeDoArquivo = "CadastroProduto.txt";

	public static void SalvarArquivoTXT () throws IOException {

		try (BufferedWriter buffer = new BufferedWriter(new FileWriter (nomeDoArquivo));
				PrintWriter pw = new PrintWriter(buffer)) {
			for (Produto a: ListaDeProdutos.getInstance())
				pw.println(a);
		}
	}

	public static void LerArquivoTXT() throws FileNotFoundException, IOException { //carregado na lista através da leitura do arquivo txt

		try(FileWriter arq = new FileWriter(nomeDoArquivo, true)){};

		String line;

		try(BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo)))  {

			while((line = reader.readLine())!= null && !"".equals(line)) { //equals utilizado para comparar objeto
				Produto produto = new Produto(line);
				ListaDeProdutos.getInstance().add(produto);

			}

		}
	}
}

//utilizado junto as informações já contidas no arquivo txt
//BufferedReader utilizado para ler informações contidas no arquivo