
public class incrementador implements Runnable {
	
	private int id;
	
	public incrementador(int id){ //para el problema con n procesos
		this.id = id;
	}
	
	@Override
	public void run() {

			//protocolo de entrada a la seccion critica
			//coge numero buscando cual es el mas alto en la lista de turnos, de tal forma que el suyo sera el siguiente
			int max = -1;
			for(int i = 0; i < 2*pc_lab2_bakery.M; i++){
				if (pc_lab2_bakery.turn[i] > max) 
					max = pc_lab2_bakery.turn[i];
			}
			pc_lab2_bakery.turn[id] = max + 1; //le asignamos su turno correspondiente

			for (int j = 0; j < pc_lab2_bakery.M && j != id; j++){
				while (pc_lab2_bakery.turn[id] >= pc_lab2_bakery.turn[j] && pc_lab2_bakery.turn[j] != -1); 
				//esperamos en esta condicion hasta que encuentra una j tal que el turno de este proceso id es menor, o sea, le toca
				//entrar en la seccion critica
			}
			
			//CS
			pc_lab2_bakery.n += pc_lab2_bakery.M;

			//protocolo de salida
			pc_lab2_bakery.turn[id] = -1;
	}
	

}
