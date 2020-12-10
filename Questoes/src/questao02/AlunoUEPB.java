package questao02;

public class AlunoUEPB implements Runnable {
	
	private Barco barco;
	private String name;
	
	public AlunoUEPB(Barco barco, String name) {
		this.barco = barco;
		this.name = name;
	}

	@Override
	public void run() {
		while(true) {
			try {
				boolean embarcou = false;
				
				while (!embarcou)
					embarcou = this.barco.embarcar(TipoAluno.UEPB, name);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

}
