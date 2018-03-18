class worker implements Runnable{
    private int id;

    public worker(int id){
        this.id = id;
    }

    public void run(){
        if(id == 0 || id % 2 == 0){
            coordinator.num -= coordinator.M;
        }else{
            coordinator.num += coordinator.M;
        }
        coordinator.arrive[id] = 1;
        while(coordinator.cont[id] ==0);
        coordinator.cont[id] = 0;
    }
}