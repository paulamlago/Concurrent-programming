//ROMPE EMPATE CON DOS PROCESOS, haciendo uso de las variables in1, in2 y last


public class pc_lab2_a{

	final static int M = 2;
	final static int N = 2000;
	protected volatile static int n = 0;

 	protected static Boolean in1 = false;
	protected static Boolean in2 = false;
	protected volatile static int last;

	static Thread[] incrementadores = new Thread[M];
	static Thread[] decrementadores = new Thread[M];
	
	public static void main(String[] args) {
				
		for (int i = 0; i < M; i++){ 
			incrementadores[i] = new Thread(new incrementador()); 
			decrementadores[i] = new Thread(new decrementador());
			decrementadores[i].start();
			incrementadores[i].start();
		}
		
		for(int i = 0; i < M; i++){
			try {
				decrementadores[i].join();
				incrementadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("The final value is: " + n);
	}

}