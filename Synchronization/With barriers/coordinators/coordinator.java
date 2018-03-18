class coordinator{
    protected final static int N = 20;
    protected final static int M = 10000;
    protected static int num = 0;

    protected static Thread[] worker;
    protected static int[] arrive;
    protected static int[] cont;

    public static void main(String args[]){
        arrive = new int[N];
        cont = new int[N];
        worker = new Thread[N];

        for(int i = 0; i < N; i++){
            arrive[i] = -1;
            cont[i] = -1;
            try{
                worker[i] = new Thread(new worker(i)); //the odd ones will be the incrementors and the even + 0, decrementors
            }catch(Exception e){
                System.out.println("Index" + i);
            }
        }

        for(int i = 0; i < N; i++){
            worker[i].start();
        }

        for(int i = 0; i < N; i++){
            while(arrive[i] != 1);
            arrive[i] = 0;
        }
        //every process is waiting for the continue flag
        for(int i = 0; i < N; i++){
            cont[i] = 1;
        }

        for(int i = 0; i < N; i++){
            try{
                worker[i].join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("FINALLY! Value is: " + num);
    }
}