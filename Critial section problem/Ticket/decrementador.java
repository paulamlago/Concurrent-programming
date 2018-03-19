
public class decrementador implements Runnable {

	private int id;
	
	public decrementador(int id){ //para el problema con n procesos
		this.id = id;
	}
	@Override
	public void run() {
			pc_lab2_ticket.turn[id] = pc_lab2_ticket.number;
			pc_lab2_ticket.number++;
			
			while (pc_lab2_ticket.turn[id] != pc_lab2_ticket.next);

			//CS
			pc_lab2_ticket.n -= pc_lab2_ticket.M;
			//FIN CS
			
			pc_lab2_ticket.next++;
	}
}
