package questao01;

import java.util.concurrent.Semaphore;

public class Carro implements Runnable{
	
	Semaphore carregando;
	Semaphore vagasEmbarque;
	Semaphore descarregando;
	private Semaphore esperaFicarCheio;
	private Semaphore esperaFicarVazio;
	private int capacidade;
	private int passageiros;
	
	
	public Carro(int capacidade) {
		this.carregando = new Semaphore(0);
		this.descarregando = new Semaphore(0);
		this.esperaFicarCheio = new Semaphore(0);
		this.esperaFicarVazio = new Semaphore(0);
		this.vagasEmbarque = new Semaphore(capacidade);
		this.capacidade = capacidade;
		this.passageiros = 0;
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
		this.carregando.release();
		System.out.println("CARREGANDO...");
	}
	
	public void embarcar(String name) throws InterruptedException {
		
		this.passageiros++;
		System.out.println("Passageiro "+ name + " embarcou");
		
		if (this.isFull()) {
			System.out.println("LOTOU...");
			this.esperaFicarCheio.release();
		}
		else
			this.carregando.release();
	}
	
	private boolean isFull() {
		return this.passageiros == this.capacidade;
	}
	
	private boolean isEmpty() {
		return this.passageiros == 0;
	}
	
	public void correr() throws InterruptedException {
		this.esperaFicarCheio.acquire();
		System.out.println("CORRENDO...");
	}
	
	public void descarregar() throws InterruptedException {
		this.descarregando.release();
		System.out.println("DESCARREGANDO...");
		this.esperaFicarVazio.acquire();
	}
	
	public void desembarcar(String name) throws InterruptedException {
		
		this.passageiros--;
		System.out.println("passageiro " + name + " saiu");
		
		if (this.isEmpty()) {
			System.out.println("ESVAZIOU...");
			this.esperaFicarVazio.release();
		}
		else
			this.descarregando.release();
	
	}

}
