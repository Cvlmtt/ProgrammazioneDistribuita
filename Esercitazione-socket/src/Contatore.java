public class Contatore {
    public volatile int contatore;

    public Contatore(){
        contatore = 0;
    }

    synchronized public void incrementa(int x){
        contatore += x;
    }

    public int getValue(){
        return contatore;
    }
}
