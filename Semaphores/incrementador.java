class incrementador implements Runnable{

    public void run(){
        try{
            pc_lab3.mutex.tryAcquire();
            pc_lab3.num += pc_lab3.M;
            pc_lab3.mutex.release();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}