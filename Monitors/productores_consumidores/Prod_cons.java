public class Prod_cons {
	private final static int N = 20, M = 1000;
	private static Thread[] prod, cons;
	private static Monitor_prodcons mon;
	
	public static void main(String[] args) {
		prod = new Thread[N];
		cons = new Thread[N];
		mon = new Monitor_prodcons();
		
		for(int i = 0; i < N; i++){
			prod[i] = new Thread(){
				public void run(){
					for(int j = 0; j < M; j++){
						mon.almacenar(new Producto());
					}
				}
			};
			cons[i] = new Thread(){
				public void run(){
					for(int j = 0; j < M; j++){
						mon.extraer();
					}
				}
			};
			
			prod[i].start();
			cons[i].start();
		}
		for(int i = 0; i < N; i++){
			try {
				prod[i].join();
				cons[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		System.out.println("Any product left to be consumed?: " + mon.lleno());
	}
}
