import java.util.Random;

public class PigrecoMontecarlo implements Runnable{
    public Counter counter;
    public static final int numberOfShoot = 10000000;
    public static int limit;
    public static final int MAXTHRD = 16;

    public PigrecoMontecarlo(Counter counter, int limit){
        this.counter = counter;
        this.limit = limit;
    }

    public static void main(String[] args) throws InterruptedException {
        /*Random rand = new Random();

        float x;
        float y;

        for (int i = 0; i < numberOfShoot; i++) {
            x = rand.nextFloat(0, 1);
            y = rand.nextFloat(0, 1);
            System.out.println("x value: "+x);
            System.out.println("y value: "+y);
            float value = x*x + y*y;
            System.out.println("x*x + y*y: "+value);
            if (((x * x) + (y * y)) < 1)
                countCirclePoint++;
        }

        System.out.println("Number of point in Circle: "+countCirclePoint);
        float circle = countCirclePoint;
        float shoot = numberOfShoot;

        double pi = (circle/shoot)*4;
        System.out.println(pi);*/

        long start = System.currentTimeMillis();
        for(int i = 1; i <= MAXTHRD; i*=2){
            PigrecoMontecarlo instanceClas[] = new PigrecoMontecarlo[i];
            Thread thrd[] = new Thread[i];

            Counter counter = new Counter();

            for(int j = 0; j < i; j++){
                instanceClas[j] = new PigrecoMontecarlo(counter, numberOfShoot/i);
                thrd[j] = new Thread(instanceClas[j]);
                thrd[j].start();
            }

            for(int k = 0; k < i; k++){
                thrd[k].join();
            }
            long time = System.currentTimeMillis()-start;

            float circle = counter.getValue();
            double pi = (circle/numberOfShoot)*4;
            System.out.println(pi);
            System.out.println(time);
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < limit; i++){
            Random rand = new Random();
            float x = rand.nextFloat(0,1);
            float y = rand.nextFloat(0,1);

            if(((x * x) + (y * y)) < 1)
                counter.increment();
        }
    }
}