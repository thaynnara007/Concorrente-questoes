package questao01;

public class Main {
	
	public static void main(String[] args) {
		
		int capacidade = 4;
		
		Buffer buffer = new Buffer(capacidade); 
		Carro carro = new Carro(buffer);
		Passageiro p1 = new Passageiro(buffer, "p1");
		Passageiro p2 = new Passageiro(buffer, "p2");
		Passageiro p3 = new Passageiro(buffer, "p3");
		Passageiro p4 = new Passageiro(buffer, "p4");
		Passageiro p5 = new Passageiro(buffer, "p5");
		Passageiro p6 = new Passageiro(buffer, "p6");
		Passageiro p7 = new Passageiro(buffer, "p7");

		
		Thread t1 = new Thread(carro);
		Thread t2 = new Thread(p1);
		Thread t3 = new Thread(p2);
		Thread t4 = new Thread(p3);
		Thread t5 = new Thread(p4);
		Thread t6 = new Thread(p5);
		Thread t7 = new Thread(p6);
		Thread t8 = new Thread(p7);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();	
	}

}
