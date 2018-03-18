import java.io.*;

class Producer implements Runnable{
    

    public void run(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String line;
        try{
            archivo = new File(main.name);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            
        while((line = br.readLine()) != null){
            while(main.buff_lleno);
            main.buf = line;
            main.buff_lleno = true;
        }
            main.done = true;
        }catch(Exception e){
            System.out.println("ups");
        }
    }

}