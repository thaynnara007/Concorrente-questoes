package questao02;

import java.util.concurrent.Semaphore;

public class SemaforosQuestao02 {
	
	BarreiraReusavel barreira;
	Semaphore mutex;
 	Semaphore UFCGfila;
 	Semaphore UEPBfila;
 	int alunosUFCG;
 	int alunosUEPB;
	
	
	public SemaforosQuestao02() {
		this.barreira = new BarreiraReusavel(4);
		this.mutex = new Semaphore(1);
		this.UFCGfila = new Semaphore(0);
		this.UEPBfila = new Semaphore(0);
		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
	}
}
