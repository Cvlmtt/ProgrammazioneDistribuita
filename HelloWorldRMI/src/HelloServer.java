import java.io.Serial;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServer extends UnicastRemoteObject implements HelloService {
    protected HelloServer() throws RemoteException {

    }

    @Serial
    private static final long serialVersionUID = 1L;

    @Override
    public String hello(String in){
        return "Hello "+in+"!";
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        System.out.println("Avvio server...");
        Naming.rebind("HelloService", new HelloServer());
        System.out.println("...Servizio registrato");
    }
}
