package questao03;

public class Mesa {
	
	private int pessoas;
	private int pessoasBebendo;
	
	public Mesa() {
		this.pessoas = 0;
		this.pessoasBebendo = 0;
	}
	
	public synchronized void entra(String name) throws InterruptedException {
		this.pessoas += 1;
		System.out.println("Aluno " + name + " entrou no mesa");
		
		/* Se ainda não tiver pelo menos 2 alunos na mesa, espera, para que não possa 
		 * beber sozinho.
		*/
		while (this.pessoas < 2) {
			wait();
		}
		
		/* Quando a quantidade de pessoas na mesa atingir 2, notificar a outra
		 *  thread que ficou esperando para poder começar a beber
		 */
		if (this.pessoas == 2 )  
			notifyAll();		
	}
	
	// Aluno começou a beber
	public void bebe(String name) throws InterruptedException {
		System.out.println("Aluno " + name + " está bebendo");
		this.pessoasBebendo += 1;
		
		this.remediado(name);
	}
	
	// Aluno terminou de beber
	public void remediado(String name) {
		System.out.println("Aluno " + name + " está remediado");
		this.pessoasBebendo -= 1;
	}
	
	// verifica se aluno pode sair, de acordo com a restrinção.
	private boolean naoPodeSair() {
		return (this.pessoasBebendo == 2 && this.pessoas <= 2);
	}
	
	public synchronized void sai(String name) throws InterruptedException {
		// Se o aluno poder sair, então sai da mesa, e espera.
		while (!this.naoPodeSair()) {
			System.out.println("Aluno " + name + " saiu da mesa");
			this.pessoas -= 1;

			System.out.println("Ficaram " + this.pessoas + " na mesa");
			wait();
		}
	}
}
