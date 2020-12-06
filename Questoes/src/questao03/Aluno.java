package questao03;

public class Aluno implements Runnable {
	
	private Mesa mesa;
	private String name;
	
	public Aluno(Mesa mesa, String name) {
		this.mesa = mesa;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			mesa.entra(name);
			mesa.bebe(name);
			mesa.sai(name);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
