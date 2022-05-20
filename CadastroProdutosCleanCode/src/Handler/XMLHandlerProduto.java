package Handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Marca;
import Modelos.Produto;

public class XMLHandlerProduto extends DefaultHandler{
	
	private StringBuilder texto;
	Produto produto;
	Marca marcaProduto;
	
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Início do Documento");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fim do Documento");	
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if(qName.equals("Produto")) {
			produto = new Produto();
			marcaProduto = new Marca();	
		} else {
			texto = new StringBuilder();
		}
	}
	
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if (qName.equals("Nome")) {
			produto.setNome(texto.toString());	
		} else if (qName.equals("Categoria")) {
			produto.setCategoria(texto.toString());
		}else if (qName.equals("Marca")) {
			marcaProduto.setNomeMarca(texto.toString());
		}else if (qName.equals("Preco")) {
			marcaProduto.setPreco(Float.parseFloat(texto.toString()));	
		}
	}
	//ao terminar de ler arquivo xml, ele carrega o objeto
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		texto.append(ch, start, length);
	}
	//inserção de caracteres
	
	@Override
	public void error(SAXParseException e) throws SAXException {
	}

}

//append é utilizado para fazer a junção dos caracteres e assim a string é formada

