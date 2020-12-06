package questao02;

public class Barco {
	
	private final int TOTAL = 4;
	private int alunosUFCG;
	private int alunosUEPB;
	
	public Barco() {
		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
	}
	
	private int alunos() {
		return this.alunosUEPB + this.alunosUFCG;
	}
	
	private boolean isFull() {
		return this.alunos() == this.TOTAL;
	}
	
	/*
	 *  Verifica, pela universidade do aluno, se ele pode ou não entrar no barco, considerando 
	 *  a configuração atual do barco
	 */
	private boolean permiteAluno(TipoAluno tipo) {
		if (this.alunos() == 3) {
			
			if (this.alunosUEPB == 2 && this.alunosUFCG == 1) {
				if (tipo.equals(TipoAluno.UEPB)) 
					return false;
			}
			else if (this.alunosUFCG == 2 && this.alunosUEPB == 1) {
				if (tipo.equals(TipoAluno.UFCG)) 
					return false;
			}
			else {
				if (this.alunosUEPB == 3 && tipo.equals(TipoAluno.UFCG))
					return false;
				if (this.alunosUFCG == 3 && tipo.equals(TipoAluno.UEPB))
					return false;
			}
		}
		return true;
	}
	
	
	public synchronized void embarcar(TipoAluno tipo, String name) throws InterruptedException {
		/* Enquanto o barco estiver lotado ou se você for um aluno, cujo sua universidade vai contra
		 * as configurações permitidas no barco, então espera.
		 */
		while (this.isFull() || !this.permiteAluno(tipo)) {
			wait();
		}
		
		// Se o aluno for da UEPB, então incrementar a quantidade de alunos da UEPB
		if (tipo.equals(TipoAluno.UEPB)) {
			System.out.println("Um aluno da UEPB entrou no barco " + name);
			this.alunosUEPB += 1;
		}
		// Se o aluno for da UFCG, então incrementa a quantidade de alunos da UFCG
		else {
			System.out.println("Um aluno da UFCG entrou no barco " + name);
			this.alunosUFCG += 1;
		}
		
		// Se o barco tiver alcançado a capacidade máxima, então a última thread que vai remar
		if (this.isFull()) {
			this.remar(tipo, name);
		}
		
		// caso o barco não esteja cheio e você tiver entrado no barco, então espera.
		wait();
	}
	
	public synchronized void remar(TipoAluno tipo, String name) throws InterruptedException {
		// Apenas um aluno pega o remo antes de chamar viajem()
		if (tipo.equals(TipoAluno.UEPB))
			System.out.println("Um aluno da UEPB vai REMAR " + name);
		else 
			System.out.println("Um aluno da UFCG vai REMAR " + name);
		
		this.viajem();
		
	}
	
	private synchronized void viajem() throws InterruptedException {
		// Colocar a thread que ta com o remo para dormir, simulando o tempo de uma viajem.
		System.out.println("ATRAVESSA O AÇUDE...");
		Thread.sleep(1000);
		
		System.out.println("ACABANDO A VIAJEM...");
		// Ao acabar a viajem, todos os alunos são retirados do barco e podem voltar a embarcar
		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
		
		/* Notifica as thread que ficaram esperando no embarcar e libera as que esperando, 
		 * dentro do barco, para dar continuidade.
		*/
		notifyAll();
	}
}
