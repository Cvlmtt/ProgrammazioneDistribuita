public class ArrThrd implements Runnable {
    private static final int DIM = 1200000;
    private static final int NUMTHRD = 2;
    private int[] arr;
    private int startArr;
    private int finishArr;

    public ArrThrd(int start, int finish, int arr[]){
        this.arr = arr;
        this.startArr = start;
        this.finishArr = finish;
    }

    public static void main(String[] args) throws InterruptedException {
        int arr1[] = new int[DIM];
        long start = System.currentTimeMillis();
        for(int i = 0; i < DIM; i++){
            arr1[i] = 42;
        }
        /*for(int j = 0; j < DIM; j++) {
            System.out.println(arr1[j]);
        }*/
        long time = System.currentTimeMillis() - start;
        System.out.println("Execution without thread: "+time);


        int arr2[] = new int[DIM];
        ArrThrd instanceClass[] = new ArrThrd[NUMTHRD];
        Thread arrayThread[] = new Thread[NUMTHRD];
        start = System.currentTimeMillis();
        for(int j = 0; j < NUMTHRD; j++){
            instanceClass[j] = new ArrThrd(j*(DIM/NUMTHRD), (j+1)*(DIM/NUMTHRD), arr2);
            arrayThread[j] = new Thread(instanceClass[j]);
            arrayThread[j].start();
        }

        for(int k = 0; k < NUMTHRD; k++){
            arrayThread[k].join();
        }

        /*for(int k = 0; k < DIM; k++){
            System.out.println(arr2[k]);
        }*/
        time = System.currentTimeMillis() - start;
        System.out.println("Execution with two thred:"+time);
    }

    @Override
    public void run() {
        for(int i = startArr; i < finishArr; i++){
            arr[i] = 42;
        }
    }
}