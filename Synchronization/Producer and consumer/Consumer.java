class Consumer implements Runnable{
    public void run(){
        while(true){
            if(!main.done) {
                while(!main.buff_lleno);
                System.out.println(main.buf);
                main.buff_lleno = false;
            }else break;
        }
    }
}