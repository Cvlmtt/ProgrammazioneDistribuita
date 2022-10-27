import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        System.out.println("Avvio client...");
        HelloService hs = (HelloService) Naming.lookup("rmi://localhost/HelloService");
        System.out.println("Look up stub");
        System.out.println(hs.hello("Pippo"));
    }
}
