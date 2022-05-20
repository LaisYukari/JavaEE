
public class Cursos {

	public String [] curso = new String[5];
	
	int contC = 0;
	int menuC = 0;
	
	public void EscolherCurso() {
		
		switch(menuC){
			
		case 1: 
			
			curso[contC] = "Pacote Office Completo";
			break;
			
		case 2: 
			
			curso[contC] = "Operador de Empilhadeira";
			break;
				
		case 3: 
			
			curso[contC] = "Metalmecânica";
			break;
			
		case 4: 
			
			curso[contC] = "Eletroeletrônica";
			break;
		}
		
		contC++;
		
	}
	
	public void MostrarValores(){
		
		switch(menuC) {
		
		case 1:
			System.out.println("");
			System.out.println("========== CURSO ==========   ");
			System.out.println("");
			System.out.println("| Pacote Office Completo  |");
			System.out.println("");
			System.out.println("Valor: R$ 1600,00");
			System.out.println("Parcelas: 6x de R$ 266,00");	
			System.out.println("A vista: 10% de desconto");
			System.out.println("Atrasado: 5% de juros");
			System.out.println("");
			System.out.println("Aluno cadastrado com sucesso!");
			break;
			
		case 2:
			System.out.println("");
			System.out.println("========== CURSO ==========   ");
			System.out.println("");
			System.out.println("|  Operador de Empilhadeira  |");
			System.out.println("");
			System.out.println("Valor: R$ 1800,00");
			System.out.println("Parcelas: 6x de R$ 300,00");	
			System.out.println("A vista: 10% de desconto");
			System.out.println("Atrasado: 5% de juros");
			System.out.println("");
			System.out.println("Aluno cadastrado com sucesso!");
			
			break;
			
		case 3:	
			System.out.println("");
			System.out.println("========== CURSO ==========   ");
			System.out.println("");
			System.out.println("|  Metalmecânica    |");
			System.out.println("");
			System.out.println("Valor: R$ 3000,00");
			System.out.println("Parcelas: 12x de R$ 250,00");	
			System.out.println("A vista: 20% de desconto");
			System.out.println("Atrasado: 6% de juros");
			System.out.println("");
			System.out.println("Aluno cadastrado com sucesso!");
			
			break;
			
		case 4:	
			System.out.println("");
			System.out.println("========== CURSO ==========   ");
			System.out.println("");
			System.out.println("|  Eletroeletrônica  |");
			System.out.println("");
			System.out.println("Valor: R$ 2500,00");
			System.out.println("Parcelas: 12x de R$ 208,00");	
			System.out.println("A vista: 20% de desconto");
			System.out.println("Atrasado: 6% de juros");
			System.out.println("");
			System.out.println("Aluno cadastrado com sucesso!");
			
			break;
			
			
		}
		
		
		
	}
	
	
	
	
	
}
