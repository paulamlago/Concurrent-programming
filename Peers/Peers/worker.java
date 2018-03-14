
class worker implements Runnable{

    private int[] a;
    private int[] b; //each worker recieves a row of the matrix a and a row of matrix b
    private int[] c;
    private int id; 

    public worker(int[] a, int[] b, int id){
        this.a = a;
        this.b = b;
        this.id = id;
        c = new int[coord.N];
    }

    public void run(){
        int suma = 0;
        int nextCol = id;

        for(int j = 0; j < coord.N; j++){
            suma = 0;
            for(int k = 0; k<coord.N;k++){
                suma += a[k]*b[k];
            }

            c[nextCol] = suma;

            if(nextCol == coord.N - 1)
                nextCol = 0;
            else nextCol++;

            b = coord.takeColum(coord.B, nextCol);
        }

        //now that we have completed c, we send it
        coord.recieveC(c, id);
    }
}