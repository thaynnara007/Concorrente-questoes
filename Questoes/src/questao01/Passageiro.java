package questao01;

public class Passageiro implements Runnable {
	
	private Buffer buffer;
	private String name;
	
	public Passageiro(Buffer buffer, String name) {
		this.buffer = buffer;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				System.out.println(this.name + " quer embarcar");
				this.buffer.embarcar(name);
				System.out.println(this.name + " quer desembarcar");
				this.buffer.desembarcar(name);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}	
	}
	
}
