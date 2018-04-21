public class incrementadores_decrementadores {
	private static final int N = 20, M = 10000;
	private static Thread[] inc, dec;

	private static Monitor_incdec mon;
	
	public static void main(String[] args) {
		inc = new Thread[N];
		dec = new Thread[N];
		mon = new Monitor_incdec();
		
		for(int i = 0; i < N; i++){
			inc[i] = new Thread(){
					public void run() {
						for(int j = 0; j < M; j++){
							mon.increment();				
						}
					}
			};
			dec[i] = new Thread(){
				public void run(){
					for(int j = 0; j < M; j++){
						mon.decrement();
					}
				}
			};
			
			inc[i].start();
			dec[i].start();
		}
		
		for(int i = 0; i < N; i++){
			try {
				inc[i].join();
				dec[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Final value is: " + mon.getnum());
	}


}
