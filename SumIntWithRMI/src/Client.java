import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        System.out.println("Avvio client...");
        Service s = (Service) Naming.lookup("rmi://localhost/Counter");
        System.out.println("Inserisci valore: ");
        int input = new Scanner(System.in).nextInt();
        s.sum(input);
        System.out.println("Value of counter: "+s.getValue());
    }
}
