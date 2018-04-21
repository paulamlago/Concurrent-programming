import java.util.Random;

public class Producto {
	private int prod;
	
	public Producto(){
		Random rand = new Random();

		prod = rand.nextInt(100) + 1;
	}
	public int getProduct(){
		return prod;
	}
}
