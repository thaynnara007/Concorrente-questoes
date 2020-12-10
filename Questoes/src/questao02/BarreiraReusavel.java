package questao02;

import java.util.concurrent.Semaphore;

public class BarreiraReusavel {
	
	private Semaphore turnstile;
	private Semaphore turnstile2;
	private Semaphore mutex;
	private int count;
	private int n;
	
	public BarreiraReusavel(int n) {
		this.turnstile = new Semaphore(0);
		this.turnstile2 = new Semaphore(1);
		this.mutex = new Semaphore(1);
		this.count = 0;
		this.n = n;
	}
	
	public void await() throws InterruptedException {
		this.mutex.acquire();
		
		this.count++;
		
		if (this.count == this.n) {
			this.turnstile2.acquire();
			this.turnstile.release();
		}
		
		this.mutex.release();
		
		this.turnstile.acquire();
		this.turnstile.release();
		
		this.mutex.acquire();
		
		this.count--;
		
		if (this.count == 0) {
			this.turnstile.acquire();
			this.turnstile2.release();
		}
		
		this.mutex.release();
		
		this.turnstile2.acquire();
		this.turnstile2.release();
	}

}
