class coord{

    public static int N = 3; //we will use 3x3 matrix

    public static int[][] C = new int[N][N]; //solution
    protected static int[][] A = new int[][]{{2, 0, 1}, {3, 0, 0}, {5, 1, 1}};
    protected static int[][] B = new int[][]{{1, 0, 1}, {1, 2, 1}, {1, 1, 0}};

    public static Thread[] workers = new Thread[N];

    //this class coordinates each worker
    public static void main(String[] args){
        
        for(int i = 0; i < N; i++){
            workers[i] = new Thread(new worker(/*A row*/A[i], /*B colum*/ takeColum(B, i), i));
            workers[i].start();
        }

        for(int i = 0; i < N; i++){
            try{
                workers[i].join();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printMatrix(C, N);
    }

    public static void recieveC(int[] c, int i){
        C[i] = c;
    }

    private static void printMatrix(int[][] m, int size){
        String line = "";

        System.out.println("The final matrix is: " + "\n");
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
               line += m[i][j] + " ";
            }
            System.out.println(line +"\n");
            line = "";
        }
    }

    public static int[] takeColum(int[][] m, int c){
        int[] bcol = new int [N];
        //I need to manually extract the B collum number i
        for(int j = 0; j < N; j++){
            bcol[j] = m[j][c];
        }
        return bcol;
    }
}