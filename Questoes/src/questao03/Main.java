package questao03;

public class Main {
	
	public static void main(String[] args) {
		
		SemafarosQuestao03 semaforos = new SemafarosQuestao03();
		Aluno p1 = new Aluno(semaforos, "p1");
		Aluno p2 = new Aluno(semaforos, "p2");
		Aluno p3 = new Aluno(semaforos, "p3");
		Aluno p4 = new Aluno(semaforos, "p4");
		Aluno p5 = new Aluno(semaforos, "p5");
		Aluno p6 = new Aluno(semaforos, "p6");
		Aluno p7 = new Aluno(semaforos, "p7");
		Aluno p8 = new Aluno(semaforos, "p8");
		Aluno p9 = new Aluno(semaforos, "p9");
		Aluno p10 = new Aluno(semaforos, "p10");
		Aluno p11 = new Aluno(semaforos, "p11");
		Aluno p12 = new Aluno(semaforos, "p12");
		Aluno p13 = new Aluno(semaforos, "p13");

		
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
