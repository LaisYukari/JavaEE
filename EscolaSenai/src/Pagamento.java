import java.util.Scanner;
import java.util.*;

public class Pagamento {

	public int menuPag = 0;
	public int menuC = 0;
	
public void CalcDesconto(){
	
		switch(menuC) {
			
		case 1:
			
			double desc;
			
			desc = (1600 * 10)/100;
			double valorFinal = 1600 - desc;
			System.out.printf("Valor: R$  " + valorFinal);
			
			break;
			
		case 2:
			
			double desc2;

			desc2 = (1800 * 10)/100;
			double valorFinal2 = 1800 - desc2;
			System.out.println("Valor: R$ " + valorFinal2);
			
			break;
	
		case 3:
			
			double desc3;

			desc3 = (3000 * 20)/100;
			double valorFinal3 =   3000 - desc3 ;
			System.out.println("Valor: R$ " + valorFinal3);
			
			break;
		
		case 4:
			
			double desc4;

			desc4 = (2500 * 0.20)/100;
			double valorFinal4 = 2500 - desc4;
			System.out.println("Valor: R$ " + valorFinal4);
			
			break;
	}
}
	
		public void CalcAtraso(){
			
			switch(menuC) {
				
			case 1:
				
				double juros;
				
				juros = (1600 * 5)/100;
				double valorFinal = juros + 1600;
				System.out.println("Valor: R$ " + valorFinal);
				
				break;
				
			case 2:
				
				double juros2;

				juros2 = (1800 * 5)/100;
				double valorFinal2 = juros2 + 1800;
				System.out.println("Valor: R$ " + valorFinal2);
				
				break;
		
			case 3:
				
				double juros3;

				juros3 = (3000 * 6)/100;
				double valorFinal3 = 3000 + juros3;
				System.out.println("Valor: R$ " + valorFinal3);
				
				break;
			
			case 4:
				
				double juros4;

				juros4 = (2500 * 6)/100;
				double valorFinal4 = 2500 + juros4;
				System.out.println("Valor: R$ " + valorFinal4);
				
				break;
	}
}
			
		public void MostrarPagamento() {
			
			switch(menuC) {
			
			case 1:
				System.out.println("====== PAGAMENTO ======");
				System.out.println("Valor Total: R$ 1600,00");
				System.out.println("Valor Parcelado em 6x: R$ 266,00");
			
				break;
				
			case 2:
				System.out.println("====== PAGAMENTO ======");
				System.out.println("Valor Total: R$ 1800,00");
				System.out.println("Valor Parcelado em 6x: R$ 300,00");
				
				break;
		
			case 3:
				
				System.out.println("====== PAGAMENTO ======");
				System.out.println("Valor Total: R$ 3000,00");
				System.out.println("Valor Parcelado em 12x: R$ 250,00");
				
				break;
			
			case 4:
				
				System.out.println("====== PAGAMENTO ======");
				System.out.println("Valor Total: R$ 2500,00");
				System.out.println("Valor Parcelado em 12x: R$ 208,00");
				
				break;
			
		}	
	}	
}