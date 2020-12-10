package questao01;

public class Passageiro implements Runnable {
	
	private Carro carro;
	private String name;
	
	public Passageiro(Carro carro, String name) {
		this.carro = carro;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				this.embarcar();
				this.desembarcar();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
	private void embarcar() throws InterruptedException {
		carro.vagasEmbarque.acquire();
		carro.carregando.acquire();
		
		this.carro.embarcar(this.name);
	}
	
	private void desembarcar() throws InterruptedException {
		carro.descarregando.acquire();
		carro.vagasEmbarque.release();
		
		this.carro.desembarcar(this.name);	
		}
	
}
