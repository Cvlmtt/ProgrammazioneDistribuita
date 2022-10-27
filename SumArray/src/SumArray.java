import java.util.Random;

public class SumArray implements Runnable{
    public static final int MAXTHRD = 16;
    public static final int DIM = 1200000;

    private int arr1[];
    private int arr2[];

    private static int[] sumArr = new int[DIM];
    private int start;
    private int finish;
    public SumArray(int arr1[], int arr2[], int start, int finish){
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.start = start;
        this.finish = finish;
    }

    public static void main(String[] args) throws InterruptedException {
        int arr1[] = new int[DIM];
        int arr2[] = new int[DIM];
        Random rand = new Random();

        for(int j = 0; j < DIM; j++){
            arr1[j] = rand.nextInt(0,10);
            arr2[j] = rand.nextInt(0,10);
        }

        for(int m = 0; m < 10; m++){
            System.out.println("arr1-"+m+": "+arr1[m] + ' ');
        }

        for(int n = 0; n < 10; n++){
            System.out.println("arr2-"+n+": "+arr2[n] + ' ');
        }

        long start = System.currentTimeMillis();
        for(int i = 1; i <= MAXTHRD; i*=2){
            Thread thrd[] = new Thread[i];
            SumArray instanceClass[] = new SumArray[i];

            for(int k = 0; k < i; k++){
                instanceClass[k] = new SumArray(arr1, arr2, k*(DIM/i), (k+1)*(DIM/i));
                thrd[k] = new Thread(instanceClass[k]);
                thrd[k].start();
            }

            for (int l = 0; l < i; l++) {
                thrd[l].join();
            }
            long time = System.currentTimeMillis()-start;
            for(int a = 0; a < 10; a++){
                System.out.println("sumArr-"+a+": "+sumArr[a] + ' ');
            }
            System.out.println("Execution with "+i+" thread: "+time);
        }
    }

    @Override
    public void run() {
        for(int i = start; i < finish; i++){
            sum(sumArr, arr1[i], arr2[i], i);
        }
    }

    synchronized public void sum(int finalArr[], int a, int b, int i){
        finalArr[i] = a + b;
    }
}