package Aplicação;

import java.io.BufferedReader;

import java.io.FileNotFoundException;

import java.io.IOException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Modelos.Aluno;
import Modelos.Endereco;
import Util.ListaDeAlunos;
import View.ViewCRUDAluno;

public class CRUDAluno {


	public static void SalvarAluno(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException, SAXException {



		Aluno aluno =  new Aluno ();
		Endereco enderecoAluno = new Endereco();

		String[] dadosAluno = ViewCRUDAluno.ViewSalvarAluno(reader);

		aluno.setNome(dadosAluno[0]);
		aluno.setCpf(Integer.parseInt(dadosAluno[1]));
		aluno.setCurso(dadosAluno[2]);
		enderecoAluno.setRua(dadosAluno[3]);
		enderecoAluno.setNum(Integer.parseInt(dadosAluno[4]));
		enderecoAluno.setBairro(dadosAluno[5]);
		enderecoAluno.setCidade(dadosAluno[6]);
		enderecoAluno.setEstado(dadosAluno[7]);
		enderecoAluno.setCep(Integer.parseInt(dadosAluno[8]));
		aluno.setEndereco(enderecoAluno);
		ListaDeAlunos.getInstance().add(aluno);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

		ViewCRUDAluno.ViewMsgFinal(0);

	}
	public static void ListarAlunosSalvos() throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {

		ListaDeAlunos.getInstance().clear();

		//ManipulacaoArquivoTXT.LerArquivoTXT(listaDeAlunos);

		ManipulacaoArquivoXML.LerArquivoXML();

			ViewCRUDAluno.ViewListaAlunoEditada();
	}

	public static void DeletarAluno(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException{


		int indice = ViewCRUDAluno.ViewMenuListaIndexada("deletar", reader);

		ListaDeAlunos.getInstance().remove(indice);

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();

		ViewCRUDAluno.ViewMsgFinal(2);
	}

	public static void EditarAluno (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException, SAXException{


		int indice = ViewCRUDAluno.ViewMenuListaIndexada("editar", reader);
		String[] dadosEditados = {"",""};
		Aluno aluno = ListaDeAlunos.getInstance().get(indice);

		dadosEditados = ViewCRUDAluno.ViewOpcaoEdicao(reader);


		switch(Integer.parseInt(dadosEditados[0])) {
		case 1: 
			aluno.setNome(dadosEditados[1]);
			break;
		case 2:
			aluno.setCpf(Integer.parseInt(dadosEditados[1]));
			break;
		case 3: 
			aluno.setCurso(dadosEditados[1]);
			break;
		case 4:
			aluno.getEndereco().setRua(dadosEditados[1]);
			break;
		case 5:
			aluno.getEndereco().setNum(Integer.parseInt(dadosEditados[1]));
			break;
		case 6:
			aluno.getEndereco().setBairro(dadosEditados[1]);
			break;
		case 7:
			aluno.getEndereco().setCidade(dadosEditados[1]);
			break;
		case 8:
			aluno.getEndereco().setEstado(dadosEditados[1]);
			break;
		case 9:
			aluno.getEndereco().setCep(Integer.parseInt(dadosEditados[1]));
			break;
		}

		ListaDeAlunos.getInstance().set(indice, aluno);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ViewCRUDAluno.ViewMsgFinal(3);
	}
}



//True para salvar um após o outro
//Caminho para gravar arquivos em txt 

//Buffered não aceita objetos, então é preciso disso para aceitar objeto. Serve para escrita 

//try força o fechamento do comando. Depois de executar, ao terminar ele fecha automaticament
