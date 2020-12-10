package questao01;

public class Passageiro implements Runnable {
	
	private String name;

	private SemaforosQuestao01 semaforos;
	
	public Passageiro(SemaforosQuestao01 semaforos, String name) {
		this.name = name;
		this.semaforos = semaforos;
	}

	@Override
	public void run() {
		while(true) {
			try {
				this.semaforos.filaEmbarque.acquire();
				this.embarcar();
				this.semaforos.filaDesembarque.acquire();
				this.desembarcar();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
	private boolean isFull() {
		return this.semaforos.capacidade == this.semaforos.embarcados;
	}
	
	private boolean isEmpty() {
		return this.semaforos.capacidade == this.semaforos.naoEmbarcados;
	}
	
	public void embarcar() throws InterruptedException {
		this.semaforos.mutex.acquire();
		
		this.semaforos.embarcados++;
		System.out.println("Passageiro "+ this.name + " embarcou");

		if (this.isFull()) {
			System.out.println("LOTOU...");
			this.semaforos.esperaFicarCheio.release();
			this.semaforos.embarcados = 0;
		}
		
		this.semaforos.mutex.release();
	}
	
	public void desembarcar() throws InterruptedException {
		this.semaforos.mutex2.acquire();
		
		this.semaforos.naoEmbarcados++;
		System.out.println("passageiro " + this.name + " saiu");
		
		if (this.isEmpty()) {
			System.out.println("ESVAZIOU...");
			this.semaforos.esperaFicarVazio.release();
			this.semaforos.naoEmbarcados = 0;
		}
		
		this.semaforos.mutex2.release();
	}
	
}
