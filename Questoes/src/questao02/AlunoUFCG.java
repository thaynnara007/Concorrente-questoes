package questao02;

public class AlunoUFCG implements Runnable{
	
	private Barco barco;
	private String name;
	
	public AlunoUFCG(Barco barco, String name) {
		this.barco = barco;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				boolean embarcou = false;
				
				while (!embarcou)
					embarcou = this.barco.embarcar(TipoAluno.UFCG, name);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
		
	}

}
