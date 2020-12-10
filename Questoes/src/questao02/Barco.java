package questao02;

import java.util.concurrent.Semaphore;

public class Barco {
	
	private final int TOTAL = 4;
	private int alunosUFCG;
	private int alunosUEPB;
	private Semaphore embarque;
	private Semaphore esperaEncher;
	
	public Barco() {
		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
		this.embarque = new Semaphore(1);
		this.esperaEncher = new Semaphore(0);
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
	
	
	public boolean embarcar(TipoAluno tipo, String name) throws InterruptedException {
		this.embarque.acquire();
		
		if (!this.permiteAluno(tipo))
				return false;
		
		
		if (tipo.equals(TipoAluno.UEPB)) {
			this.alunosUEPB++;
			System.out.println("O aluno " + name + " da UEPB embarcou.");
		}
		else {
			this.alunosUFCG++;
			System.out.println("O aluno " + name + " da UFCG embarcou.");

		}
		
		if(this.isFull()) 
			this.esperaEncher.release();
		
		this.esperaEncher.acquire();
		this.esperaEncher.release();
		
		this.embarque.release();
		return true;	
	}
	
	public void remar(TipoAluno tipo, String name) throws InterruptedException {
		// Apenas um aluno pega o remo antes de chamar viajem()
		if (tipo.equals(TipoAluno.UEPB))
			System.out.println("O aluno " + name + " da UEPB vai remar.");
		else 
			System.out.println("O aluno " + name + " da UFCG vai remar.");
		
		this.viajem();
		
	}
	
	private void viajem() throws InterruptedException {
		System.out.println("ATRAVESSA O AÇUDE...");
		
		System.out.println("ACABANDO A VIAJEM...");
		
		// Ao acabar a viajem, todos os alunos são retirados do barco e podem voltar a embarcar
		this.alunosUEPB = 0;
		this.alunosUFCG = 0;
	}
}
