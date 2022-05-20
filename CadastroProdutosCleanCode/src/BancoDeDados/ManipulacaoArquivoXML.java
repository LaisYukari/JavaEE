package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Handler.XMLHandlerProduto;
import Modelos.Produto;
import Util.ListaDeProdutos;


public class ManipulacaoArquivoXML {

	private static String nomeDoArquivo = "CadastroProduto.xml";

	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); //construção de documentos
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.newDocument();
		
		//as tags são salvas conforme tag aberta (uma é salva dentro da outra)

		Element produtosTag = doc.createElement("Produtos");  
		doc.appendChild(produtosTag);

		for(Produto a: ListaDeProdutos.getInstance()) {
			//listagem de produtos e seus atributos

			Element produtoTag = doc.createElement("Produto");
			produtoTag.setAttribute("id", "1");
			produtosTag.appendChild(produtoTag);


			Element nomeTag = doc.createElement("Nome");
			nomeTag.setTextContent(a.getNome());
			produtoTag.appendChild(nomeTag);

			Element categoriaTag = doc.createElement("Categoria");
			categoriaTag.setTextContent(a.getCategoria());
			produtoTag.appendChild(categoriaTag);

			Element marcaTag = doc.createElement("MarcaProduto");
			produtoTag.appendChild(marcaTag);

			Element nomeMarcaTag = doc.createElement("Marca");
			nomeMarcaTag.setTextContent(a.getMarca().getNomeMarca());
			produtoTag.appendChild(nomeMarcaTag);

			Element precoTag = doc.createElement("Preco");
			precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));
			produtoTag.appendChild(precoTag);

		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}ident-amount", "4");

		DOMSource source = new DOMSource(doc);  //utilizar junto ao TXT

		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")) { //formatação
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
		}
	}
	public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {

		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();

		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo),"ISO-8859-1")) {

			InputSource source = new InputSource(isr);
			XMLHandlerProduto handler = new XMLHandlerProduto();
			parser.parse(source, handler);

		}


	}
}

