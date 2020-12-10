package questao02;

public class AlunoUEPB implements Runnable {
	
	private SemaforosQuestao02 semaforos;
	private String name;
	private boolean remador;
	
	public AlunoUEPB(SemaforosQuestao02 semaforos, String name) {
		this.semaforos = semaforos;
		this.name = name;
		this.remador = false;
	}

	@Override
	public void run() {
		try {
			this.embarcar();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void embarcar() throws InterruptedException {
		this.semaforos.mutex.acquire();
		
		this.semaforos.alunosUEPB++;
		
		if (this.semaforos.alunosUEPB == 4) {
			this.semaforos.UEPBfila.release(4);
			this.semaforos.alunosUEPB = 0;
			this.remador = true;
		}
		else if (this.semaforos.alunosUEPB == 2 && this.semaforos.alunosUFCG >= 2) {
			this.semaforos.UEPBfila.release(2);
			this.semaforos.UFCGfila.release(2);
			
			this.semaforos.alunosUFCG -= 2;
			this.semaforos.alunosUEPB = 0;
			this.remador = true;
		}
		else
			this.semaforos.mutex.release();
		
		this.semaforos.UEPBfila.acquire();
		
		System.out.println("O aluno " + this.name + " da UEPB embarcou.");
		
		this.semaforos.barreira.await();
		
		if (this.remador)
			this.remar();
	}
	
	private void remar() {
		System.out.println("O aluno " + this.name + " da UEPB esta remando.");
		this.semaforos.mutex.release();
	}

}
