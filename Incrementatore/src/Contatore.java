public class Contatore {
    private int counter = 0;
    public Contatore(){}

    synchronized public void incrementa(){
        counter++;
    }

    public int getValue(){
        return counter;
    }
}
