class Consumidor implements Runnable{
    public void run(){
        try{
            pc_lab3_b.lleno.acquire();

            Producto consumo = pc_lab3_b.almacen[pc_lab3_b.ini];
            pc_lab3_b.ini = (pc_lab3_b.ini + 1) % pc_lab3_b.M;
            System.out.println("He consumido el producto: " + consumo.getId());

            pc_lab3_b.vacio.release();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}