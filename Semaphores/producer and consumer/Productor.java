import java.util.Random;

class Productor implements Runnable{
    public void run(){
        Random randomgenerator = new Random();
        try{
            pc_lab3_b.vacio.acquire();

            int num = randomgenerator.nextInt(100);
            pc_lab3_b.almacen[pc_lab3_b.fin] = new Producto(num);
            pc_lab3_b.fin = (pc_lab3_b.fin + 1)% pc_lab3_b.M;
            System.out.println("He producido el " + num);

            pc_lab3_b.lleno.release();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}