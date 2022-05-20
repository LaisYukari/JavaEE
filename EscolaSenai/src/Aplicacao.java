import java.util.*;

public class Aplicacao {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);	
	
	Aluno cadAluno = new Aluno();
	Cursos cadCurso = new Cursos();
	Pagamento pag = new Pagamento();
	
	int i = 0;
	int menu = 1;
	
	
	while(menu != 5) {
		
		System.out.println("");
		System.out.println("========== MENU ==========");
		System.out.println("| 1 - Cadastro de Aluno |");
		System.out.println("| 2 - Remover Cadastro  |");	
		System.out.println("| 3 - Pagamento         |");
		System.out.println("| 4 - Mostrar Alunos    |");
		System.out.println("| 5 - Sair              |");
		menu = scan.nextInt();

		
	switch(menu) {
	
	case 1:
		
		scan.nextLine();
		
		System.out.println("Digite o nome do aluno:");
		cadAluno.nome[cadAluno.cont] = scan.nextLine();
		
		System.out.println("Digite a idade do aluno:");
		cadAluno.idade[cadAluno.cont] = scan.nextInt();
		
		scan.nextLine();
		
		System.out.println("Digite o CPF do aluno:");
		cadAluno.cpf[cadAluno.cont] = scan.nextLine();
		
		System.out.println("Digite o telefone do aluno:");
		cadAluno.tel[cadAluno.cont] = scan.nextLine();
		
		System.out.println("Digite o endereço do aluno:");
		cadAluno.end[cadAluno.cont] = scan.nextLine();
		
		cadAluno.Cadastrar();
		System.out.println("");
		System.out.println("Escolha o curso do aluno:");
		System.out.println("");
		System.out.println("   ========== CURSOS ==========   ");
		System.out.println("| 1 - Pacote Office Completo    |");
		System.out.println("| 2 - Operador de Empilhadeira  |");	
		System.out.println("| 3 - Metalmecânica             |");
		System.out.println("| 4 - Eletroeletrônica          |");
		System.out.println("");
		cadCurso.menuC = scan.nextInt();
		
		cadCurso.EscolherCurso();
		cadCurso.MostrarValores();
		
		break;
		
	case 2:
		
		cadAluno.ExcluirAluno();
		
		break;
		
	case 3:
		
		scan.nextLine();
		
		System.out.println("Digite o código do aluno que deseja realizar o pagamento:");
		cadAluno.cpfA = scan.nextLine();
		
		System.out.println("Escolha o curso que está matriculado:");
		System.out.println("");
		
		System.out.println(" ========== CURSOS ==========");
		System.out.println("| 1 - Pacote Office Completo    |");
		System.out.println("| 2 - Operador de Empilhadeira  |");	
		System.out.println("| 3 - Metalmecânica             |");
		System.out.println("| 4 - Eletroeletrônica          |");
		System.out.println("");
		pag.menuC = scan.nextInt();
		System.out.println("");
		
		System.out.println("   ========== PAGAMENTO ==========");
		System.out.println("| 1 - A Vista                    |");
		System.out.println("| 2 - Atrasado                   |");	
		System.out.println("| 3 - Parcelado                  |");
		pag.menuPag = scan.nextInt();
		System.out.println("");
		
		switch(pag.menuPag) {
		
		case 1:
			
			pag.CalcDesconto();
			break;
			
		case 2:
			
			pag.CalcAtraso();
			break;
		
		case 3: 	
			
			pag.MostrarPagamento();
			break;
		}
		
		break;
		
	case 4:
		
		cadAluno.MostrarAlunos();
		
	}
	
}

	
	
	
	
	scan.close();
}
}
