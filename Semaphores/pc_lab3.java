import java.util.concurrent.Semaphore;

class pc_lab3{
    public static Semaphore mutex;
    public static Thread[] incrementadores, decrementadores;
    public static final int N = 10;
    public static final int M = 10000;
    public static int num = 0;

    public static void main(String args[]){
        incrementadores = new Thread[N];
        decrementadores =  new Thread[N];
        mutex = new Semaphore(0);
        for(int i = 0; i < N; i++){
            incrementadores[i] = new Thread(new incrementador());
            decrementadores[i] = new Thread(new decrementador());
            incrementadores[i].start();
            decrementadores[i].start();
        }

        for(int i = 0; i < N; i++){
            try{
                incrementadores[i].join();
                decrementadores[i].join();
            }catch(Exception e){
                System.out.println("Main except thrown");
                e.printStackTrace();
            }
        }

        System.out.println("Final value is: " + num);
    }
}