import java.util.concurrent.CyclicBarrier;

class mariposa{
    protected static Thread[] process;
    protected static int[] a, sum, old;
    protected static final int N = 8; //it has to be a power of 2, or in case we need more processes we would need "fake" processes
    protected static CyclicBarrier barrier;

    public static void main(String[] args){
    a = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
                    //solution must be 1 3 6 10 15 21
        sum = new int[N];
        old =  new int[N];
        barrier = new CyclicBarrier(N);
        process = new Thread[N];

        for(int i = 0; i < N; i++){
            process[i] = new Thread(new process(i));
        }

        for(int i = 0; i < N; i++){
            process[i].start();
        }

        for(int i = 0; i < N; i++){
            try{
                process[i].join();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        System.out.println(sum[0] + " " +sum[1] + " " +sum[2] + " " +sum[3] + " " + sum[4] + " " + sum[5]+ " " + sum[6]+ " " + sum[7]);
    }

    
}