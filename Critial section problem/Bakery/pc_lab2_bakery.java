//TICKET PARA HACERLO CON N PROCESOS

public class pc_lab2_bakery {
	final static int M = 10; //creamos 10 hilos
	final static int N = 2000; //cada uno lo modifica en 2000 unidades
	protected volatile static int n = 0; //numero que incrementamos o decrementamos
	
	protected static Integer[] turn = new Integer[2*M]; 

	static Thread[] incrementadores = new Thread[M];
	static Thread[] decrementadores = new Thread[M];
	
	public static void main(String[] args) {
		//inicializamos turno a -1 como si no lo hubiesen pedido aun
		for(int i = 0; i < 2*M; i++){
			turn[i] = -1;
		}
		
		for (int i = 0; i < M; i++){
			incrementadores[i] = new Thread(new incrementador(i)); //los incrementadores tendran ids de 0 hasta M -1
			decrementadores[i] = new Thread(new decrementador(i + M)); //los decrementadores tendran ids de M a 2M -1
			decrementadores[i].start(); //empezamos ambos procesos
			incrementadores[i].start();
		}
		
		for(int i = 0; i < M; i++){
			try {
				decrementadores[i].join(); //esperamos a que acaben todos los procesos
				incrementadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("The final value is: " + n);
	}

}
