package questao01;

public class Buffer {
	
	private int passageiros = 0;
	private int capacidade;
	private boolean carregar;
	private boolean descarregar;
	
	
	public Buffer(int total) {
		this.capacidade = total;
		this.carregar = false;
		this.descarregar = false;
	}
	
	private boolean isFull() {
		return this.capacidade == this.passageiros;
	}
	
	private boolean isEmpty() {
		return this.passageiros == 0;
	}
	
	public synchronized void embarcar(String name) throws InterruptedException {
		// Enquanto o carro não tiver chamado o carregar ou se o carro estiver cheio, esperar.
		while (!this.carregar || this.isFull()) {
			wait();
		}
		// Adicionando um passageiro
		this.passageiros += 1;
		
		System.out.println(name + " Embarcou.");
		
		// Caso o carro fique cheio, acordar thread do carro, para que esta possa acionar o método correr.
		if (this.isFull()) {
			this.carregar = false;
			notifyAll();
		}
	}
	
	public synchronized void desembarcar(String name) throws InterruptedException {
		// Enquanto o carro não estiver em modo de descarrga ou  se o carro estiver vazio, esperar
		while(!this.descarregar || this.isEmpty()) {
			wait();
		}
		this.passageiros -= 1;
		
		System.out.println(name + " Desembarcou");
		// Se o carro ficar vazio, noticar o carro de que todos os passageiros sairam.
		if (this.isEmpty()) {
			descarregar = false;
			notifyAll();
		}
	}
	
	public synchronized void carregar() throws InterruptedException {
		// Enquanto não estiver cheio, esperar embarcar a quantidade suficiente de passageiros
		while (!this.isFull()) {

			this.carregar = true;
			// Notificar as threads passageiras que estavam esperando para embarcar
			notifyAll();
			// esperar esta lotado 
			wait();
		}
		this.carregar = false;
	}
	
	public synchronized void descarregar() throws InterruptedException {
		// Enquanto tiver passageiros no carro, ficar no estado de descarga
		while (!this.isEmpty()) {
			this.descarregar = true;
			
			// notificar passageiros que estavam esperando para desembarcar.
			notifyAll();
			wait();
		}
		this.descarregar = false;
	}
	
	public void correr() throws InterruptedException {
		// um sleep para simular uma corrida
		Thread.sleep(1000);
	}
	
}

