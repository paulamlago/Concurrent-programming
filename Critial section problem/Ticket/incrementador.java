
public class incrementador implements Runnable {
	
	private int id;
	
	public incrementador(int id){ //para el problema con n procesos
		this.id = id;
	}
	
	@Override
	public void run() {

			//protocolo de entrada a la seccion critica
			pc_lab2_ticket.turn[id] = pc_lab2_ticket.number; //coge numero
			pc_lab2_ticket.number = pc_lab2_ticket.number + 1; //siguiente numero disponible

			while (pc_lab2_ticket.turn[id] != pc_lab2_ticket.next); //esperamos en esta condicion

			//CS
			pc_lab2_ticket.n += pc_lab2_ticket.M;

			//protocolo de salida
			pc_lab2_ticket.next++; //no es necesario que hagamos esta ejecucion atomica ya que solo puede
									//haber un proceso a la vez en este punto, no se van a entrelazar.


	}
	

}
