package questao03;

public class Aluno implements Runnable {
	
	private SemafarosQuestao03 semaforos;
	private String name;
	
	public Aluno(SemafarosQuestao03 semaforos, String name) {
		this.semaforos = semaforos;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			this.bebe();
			this.sai();
			System.out.println("O aluno " + name + " saiu.");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	private void bebe() throws InterruptedException {
		this.semaforos.mutex.acquire();
		
		System.out.println("o Aluno " + this.name + " está bebendo.");
		
		this.semaforos.bebendo++;
		if (this.semaforos.bebendo == 2 && this.semaforos.remediados == 1) {
			this.semaforos.podeSair.release();
		}
		
		this.semaforos.mutex.release();
	}
	
	private void sai() throws InterruptedException {
		this.semaforos.mutex.acquire();
		
		this.semaforos.bebendo--;
		this.semaforos.remediados++;
		
		System.out.println("O aluno " + this.name + " está remediado.");
		
		if (this.semaforos.bebendo == 1 && this.semaforos.remediados == 1) {
			this.semaforos.mutex.release();
			this.semaforos.podeSair.acquire();
		}
		else if (this.semaforos.bebendo == 0 && this.semaforos.remediados == 2) {
			this.semaforos.podeSair.release();
			this.semaforos.remediados -= 2;
			this.semaforos.mutex.release();
		}
		else {
			this.semaforos.remediados--;
			this.semaforos.mutex.release();
		}
	}
}
