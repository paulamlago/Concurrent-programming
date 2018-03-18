class MainTestAndSet{
    //solucion no justa para resolver el problema de la seccion critica
    public static Boolean lock = false;
    public static final int N = 10;
    public static final int M = 10000;
    public static int sol = 0;

    protected static Thread[] inc = new Thread[N];
    protected static Thread[] dec = new Thread[N];

    public static void main(String[] args) {
        for(int i = 0; i < N; i++){
            inc[i] = new Thread(new incrementador());
            dec[i] = new Thread(new decrementador());
        }

        for(int i = 0; i < N; i++){
            inc[i].start();
            dec[i].start();
        }

        for(int i = 0; i < N; i++){
            try{
                inc[i].join();
                dec[i].join();
            }catch(Exception e){
                System.out.println("ups");
            }
        }

        System.out.println("The final solution is: " + sol);
    }

    public static Boolean TS(){
        Boolean init = lock;
        lock = true;
        return init;
    }
}