
public class Relogio {
	
	Ponteiro ponteiroHora = new Ponteiro();
	Ponteiro ponteiroMinuto = new Ponteiro();
	Ponteiro ponteiroSegundo = new Ponteiro();
	void acertarRelogio(int hora, int minuto, int segundo) {
		hora = hora % 12;
		
		ponteiroHora.posicao = hora;
		ponteiroMinuto.posicao = minuto / 5;
		ponteiroSegundo.posicao = segundo / 5;
	}
	int lerHora() {
		return ponteiroHora.posicao;
	}
	int lerMinuto() {
		return ponteiroMinuto.posicao * 5;
	}
	int lerSegundo() {
		return ponteiroSegundo.posicao * 5;
	}
	
}
