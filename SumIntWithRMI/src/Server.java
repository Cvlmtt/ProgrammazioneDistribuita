import java.io.Serial;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server{
    protected Server() throws RemoteException {
    }

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        System.out.println("Avvio server...");
        Server s = new Server();
        Counter c = new Counter();
        Naming.rebind("Counter", c);
        System.out.println("...Servizio registrato");
    }
}
