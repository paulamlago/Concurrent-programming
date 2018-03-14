//ROMPE EMPATE PARA HACERLO CON N PROCESOS

public class pc_lab2_b {
	final static int M = 10;
	final static int N = 2000;
	protected volatile static int n = 0;
	
	protected static Integer[] in = new Integer[2*M + 1]; //Etapa en la que se encuentra cada hilo
	protected static Integer[] last = new Integer[2*M + 1]; //Ultimo proceso en llegar
	//+1 porque no contamos con el 0
	
	static Thread[] incrementadores = new Thread[M + 1];
	static Thread[] decrementadores = new Thread[M + 1];
	
	public static void main(String[] args) {
		//inicializamos a 0 ambos arrays
		for(int i = 1; i < 2*M + 1; i++){
			in[i] = 0;
			last[i] = 0;
		}
		
		for (int i = 1; i <= M; i++){ //empezamos en 1 asi que la pos 0 no la contamos
			incrementadores[i] = new Thread(new incrementador(i)); //no queremos asignar el 0 porque est� inicializado a 0
			decrementadores[i] = new Thread(new decrementador(i + M));
			decrementadores[i].start();
			incrementadores[i].start();
		}
		
		for(int i = 1; i <= M; i++){
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
