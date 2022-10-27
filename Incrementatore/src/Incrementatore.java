import org.w3c.dom.css.Counter;

public class Incrementatore implements Runnable{
    private Contatore counter;

    public Incrementatore(Contatore _counter){
        this.counter = _counter;
    }

    public static void main(String[] args) throws InterruptedException {
        Contatore c = new Contatore();

        for(int i = 0; i < 40000; i++){
            c.incrementa();
        }
        System.out.println("Valore contatore:" + c.getValue());

        Contatore c2 = new Contatore();
        Incrementatore incr[] = new Incrementatore[4];
        Thread thrd[] = new Thread[4];
        for(int i = 0; i < 4; i++){
            incr[i] = new Incrementatore(c2);
            thrd[i] = new Thread(incr[i]);
            thrd[i].start();
        }

        for(int i = 0; i < 4; i++){
            thrd[i].join();
        }

        System.out.println("Valore contatore:" + c2.getValue());
    }

    @Override
    public void run() {
        for(int i = 0; i < 10000; i++){
            counter.incrementa();
        }

        //nel caso in cui si vuole rendere scalabile sul numero di thread
        /*while(counter.getValue() < 40000){
            counter.incrementa();
        }*/
    }
}