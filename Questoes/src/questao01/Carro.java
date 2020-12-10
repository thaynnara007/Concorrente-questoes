package questao01;

public class Carro implements Runnable{
	
	private SemaforosQuestao01 semaforos;
	
	public Carro(SemaforosQuestao01 semaforos) {
		this.semaforos = semaforos;
	}

	@Override
	public void run() {
		while(true) {
			try {
				this.carregar();
				this.correr();
				this.descarregar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void carregar() throws InterruptedException {
		System.out.println("CARREGANDO...");
		this.semaforos.filaEmbarque.release(this.semaforos.capacidade);
		this.semaforos.esperaFicarCheio.acquire();
	}
	
	
	public void correr() throws InterruptedException {
		System.out.println("CORRENDO...");
	}
	
	public void descarregar() throws InterruptedException {
		System.out.println("DESCARREGANDO...");
		this.semaforos.filaDesembarque.release(this.semaforos.capacidade);
		this.semaforos.esperaFicarVazio.acquire();
	}
	


}
