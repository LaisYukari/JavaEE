import java.util.Scanner;

public class Aluno {
	
	public String[] nome = new String[10];
	public String[] tel = new String[10];
	public int[] idade = new int[10];
	public String[] cpf = new String[10];
	public String[] end = new String[10];

	public String cpfA;
	public	int cont = 0;
	public int codAluno;
	public int i = 0;
	
	Scanner scan = new Scanner(System.in);
	
	public void Cadastrar() {
		
		cont++;
		codAluno = cont;
		
	}
	
	public void ExcluirAluno() {
		
		int excluir = 0;
		
		System.out.println("Digite o código do aluno que deseja remover:");
		codAluno = scan.nextInt();
		
		
		for(int i = 0; i < cont; i++) {
			if (codAluno != i) {
				excluir = 0;
			}else{
				cpf[i] = "";
				nome[i] = "";
				end[i] = "";
				idade[i] = 0;
				tel[i] = "";
				excluir = 1;
				break;
			}
			
		}
		
		if (excluir == 1) {
			System.out.println("Cadastro excluido com sucesso!");
		}else {
			System.out.println("Cadastro não encontrado!");
		}
}
		
		public void MostrarAlunos() {
			
			for ( i = 0; i < cont; i++) {
				
				System.out.println();
				System.out.print(i + "   ");
				System.out.print(nome[i] + "   ");
				System.out.print(idade[i] + "   ");
				System.out.print(cpf[i] +  "   ");
				System.out.print(end[i] + "   ");
				System.out.print(tel[i] + "   ");
				
				}
			
		
		}

}
