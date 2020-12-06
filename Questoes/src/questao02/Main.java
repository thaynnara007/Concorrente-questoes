package questao02;

public class Main {
	
	public static void main(String[] args) {
		
		Barco barco = new Barco(); 
		AlunoUEPB p1 = new AlunoUEPB(barco, "p1");
		AlunoUFCG p2 = new AlunoUFCG(barco, "p2");
		AlunoUEPB p3 = new AlunoUEPB(barco, "p3");
		AlunoUFCG p4 = new AlunoUFCG(barco, "p4");
		AlunoUEPB p5 = new AlunoUEPB(barco, "p5");
		AlunoUFCG p6 = new AlunoUFCG(barco, "p6");
		AlunoUEPB p7 = new AlunoUEPB(barco, "p7");
		AlunoUFCG p8 = new AlunoUFCG(barco, "p8");
		AlunoUFCG p9 = new AlunoUFCG(barco, "p9");
		AlunoUFCG p10 = new AlunoUFCG(barco, "p10");
		AlunoUFCG p11 = new AlunoUFCG(barco, "p11");
		AlunoUFCG p12 = new AlunoUFCG(barco, "p12");
		AlunoUEPB p13 = new AlunoUEPB(barco, "p13");

		
		Thread t1 = new Thread(p8);
		Thread t2 = new Thread(p1);
		Thread t3 = new Thread(p2);
		Thread t4 = new Thread(p3);
		Thread t5 = new Thread(p4);
		Thread t6 = new Thread(p5);
		Thread t7 = new Thread(p6);
		Thread t8 = new Thread(p7);
		Thread t9 = new Thread(p9);
		Thread t10 = new Thread(p10);
		Thread t11 = new Thread(p11);
		Thread t12 = new Thread(p12);
		Thread t13 = new Thread(p13);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();	
		t9.start();	
		t10.start();	
		t11.start();	
		t12.start();	
		t13.start();
	}

}