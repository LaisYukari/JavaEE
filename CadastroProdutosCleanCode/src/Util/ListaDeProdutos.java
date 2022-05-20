package Util;

//pode ser neceessário para incrementar 

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListaDeProdutos {
	
	private static List<Produto> listaDeProduto = new ArrayList<Produto>();//nova lista de produtos
	
	public static List<Produto> getInstance(){
		return listaDeProduto;
	}

}
//carregar lista