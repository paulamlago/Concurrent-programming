
public class decrementador implements Runnable {

	private int id;
	
	public decrementador(){

	}

	public decrementador(int id){ //para el problema con n procesos
		this.id = id;
	}
	@Override
	public void run() {
			for(int j = 1; j <= 2*pc_lab2_b.M;j++){ //REPRESENTA PASAR POR TODAS LAS ETAPAS
				pc_lab2_b.in[id] = j;
				pc_lab2_b.last[j] = id;
			
				for (int k = 1; k <= 2*pc_lab2_b.M; k++){
					if (k != id)
						while (pc_lab2_b.in[k] >= pc_lab2_b.in[id] && pc_lab2_b.last[j] == id);
					//ESPERA EN LA ETAPA EN LA QUE ESTAMOS HASTA QUE SEA EL PRIMERO QUE ENTRo
				}
			}
			
			//CS
			for (int i = 0; i < pc_lab2_b.N; i++){
				pc_lab2_b.n--;
			}
			//FIN CS
			
			pc_lab2_b.in[id] = 0;
			

		/* HECHO PARA CUANDO SOLO TENEMOS DOS PROCESOS
		pc_lab2_a.in2 = true;
		pc_lab2_a.last = 2;

		while (pc_lab2_a.in1 && pc_lab2_a.last == 2);

		for (int i = 0; i < pc_lab2_a.N; i++){
			pc_lab2_a.n--;
		}

		pc_lab2_a.in2 = false;
		*/ 
		}
	

		

}
