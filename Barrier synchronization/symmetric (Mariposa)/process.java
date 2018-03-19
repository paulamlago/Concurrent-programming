class process implements Runnable{
    private int id;

    public process(int i){
        this.id = i;
    }
    
    public void run(){
        int etapa = 1;
        mariposa.sum[id] = mariposa.a[id]; //init value

        while(etapa < mariposa.N){
            mariposa.old[id] = mariposa.sum[id]; //saved bc maybe some other process needs this value
            //every process stop at this point
            try{
                mariposa.barrier.await();//blocks here untill every process is at this point
            }catch(Exception e){
                e.printStackTrace();
            } 
            if((id - etapa) >= 0){
                mariposa.sum[id] += mariposa.old[id - etapa];
            }
            //every process stop at this point
            try{
                mariposa.barrier.await();
            }catch(Exception e){
                e.printStackTrace();
            }
            etapa += etapa; //gets duplicated
        }
    }
}