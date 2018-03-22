import java.util.concurrent.Semaphore;

class pc_lab3_b{
    public static Producto[] almacen; //circular buffer
    public static Semaphore lleno, vacio;
    public static Thread[] productor, consumidor;
    public static final int N = 10, M = 1000;
    public static int ini = 0, fin = 0;

    public static void main(String args[]){
        lleno = new Semaphore(0);
        vacio = new Semaphore(N);
        productor = new Thread[N];
        consumidor = new Thread[N];
        almacen = new Producto[M];

        for(int i = 0; i < N; i++){
            productor[i] = new Thread(new Productor());
            consumidor[i] = new Thread(new Consumidor());
            productor[i].start();
            consumidor[i].start();
        }

        for(int i = 0; i < N; i++){
            try{
                productor[i].join();
                consumidor[i].join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        System.out.println("Quedan elementos en el buffer = " + ((fin == ini) ? "no":"Si"));
    }
}