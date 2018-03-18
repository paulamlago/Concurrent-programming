public class incrementador implements Runnable{

    public incrementador(){
        
    }

    public void run(){
            while(MainTestAndSet.lock);
            //en este punto esta a false
            while(MainTestAndSet.TS()){
                while(MainTestAndSet.lock);
            }
            MainTestAndSet.sol += MainTestAndSet.M;
            
            MainTestAndSet.lock = false;
    }
}