package questao01;

public class Carro implements Runnable{
	
	private Buffer buffer;
	
	public Carro(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("CARREGANDO...");
				this.buffer.carregar();
				System.out.println("CORRIDA...");
				this.buffer.correr();
				System.out.println("DESCARREGAMENTO...");
				this.buffer.descarregar();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	

}
