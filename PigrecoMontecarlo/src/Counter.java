public class Counter {
    int counter = 0;

    public Counter(){

    }

    synchronized public void increment(){
        counter++;
    }

    public int getValue(){
        return counter;
    }
}
