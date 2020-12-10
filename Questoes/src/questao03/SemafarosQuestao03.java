package questao03;

import java.util.concurrent.Semaphore;

public class SemafarosQuestao03 {
	
	int bebendo;
	int remediados;
	Semaphore mutex;
	Semaphore podeSair;
	
	public SemafarosQuestao03() {
		this.bebendo = 0;
		this.remediados = 0;
		this.mutex = new Semaphore(1);
		this.podeSair = new Semaphore(0);
	}

}
