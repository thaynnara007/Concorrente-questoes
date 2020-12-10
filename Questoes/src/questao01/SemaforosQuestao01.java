package questao01;

import java.util.concurrent.Semaphore;

public class SemaforosQuestao01 {
	
	Semaphore filaDesembarque;
	Semaphore filaEmbarque;
	Semaphore esperaFicarCheio;
	Semaphore esperaFicarVazio;
	Semaphore mutex;
	Semaphore mutex2;
	int capacidade;
	int embarcados;
	int naoEmbarcados;
	
	public SemaforosQuestao01(int capacidade) {
		this.esperaFicarCheio = new Semaphore(0);
		this.esperaFicarVazio = new Semaphore(0);
		this.filaEmbarque = new Semaphore(0);
		this.filaDesembarque = new Semaphore(0);
		this.mutex = new Semaphore(1);
		this.mutex2 = new Semaphore(1);
		this.capacidade = capacidade;
		this.embarcados = 0;
		this.naoEmbarcados = 0;
	}
	
}
