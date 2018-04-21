public class Monitor_prodcons{
	private Producto p;
	private Boolean lleno = false;
	
	public Monitor_prodcons(){

	}
	
	synchronized void almacenar(Producto producto) {
		while(lleno){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		p = producto;
		lleno = true;
		
		notifyAll();
	}

	synchronized Producto extraer() {
		while(!lleno){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Producto s = p;
		lleno = false;
		notifyAll();
		return s;
	}
	
	protected Boolean lleno(){
		return lleno;
	}
}
