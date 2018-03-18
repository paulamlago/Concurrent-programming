
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
			for (int i = 0; i < pc_lab2_ticket.N; i++){
				pc_lab2_ticket.n--;
			}
			//FIN CS
			
			pc_lab2_ticket.next++;
	}
}
