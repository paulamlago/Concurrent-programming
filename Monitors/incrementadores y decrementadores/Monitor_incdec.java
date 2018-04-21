
public class Monitor_incdec {
	private static int num;
	
	public Monitor_incdec(){
		num = 0;
	}

	public synchronized void increment(){
		num++;
	}
	public synchronized void decrement(){
		num--;
	}
	public int getnum(){
		return num;
	}
}
