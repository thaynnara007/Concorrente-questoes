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
		
		while (this.pessoas < 2) {
			wait();
		}
		
		if (this.pessoas == 2 )  
			notifyAll();		
	}
	
	public void bebe(String name) throws InterruptedException {
		System.out.println("Aluno " + name + " está bebendo");
		this.pessoasBebendo += 1;
		
		this.remediado(name);
	}
	
	public void remediado(String name) {
		System.out.println("Aluno " + name + " está remediado");
		this.pessoasBebendo -= 1;
	}
	
	private boolean naoPodeSair() {
		return (this.pessoasBebendo == 2 && this.pessoas <= 2);
	}
	
	public synchronized void sai(String name) throws InterruptedException {

		while (!this.naoPodeSair()) {
			System.out.println("Aluno " + name + " saiu da mesa");
			this.pessoas -= 1;

			System.out.println("Ficaram " + this.pessoas + " na mesa");
			wait();
		}
	}
}
