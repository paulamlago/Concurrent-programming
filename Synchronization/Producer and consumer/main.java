class main{

    private static Thread producer = new Thread(new Producer());
    private static Thread consumer = new Thread(new Consumer());
    protected static String buf;
    public static Boolean buff_lleno = false;
    public static Boolean done = false;
    public static String name = "/home/paulamlago/Documents/Tercero/PC/Synchronization/Producer and consumer/fichero.txt";

    public static void main(String[] args){
        try{
            producer.start();
            consumer.start();

            producer.join();
            consumer.join();

            System.out.println("Fin impresion :)");
        }catch(Exception e){
            System.out.println("main");
        }
        
    }
}