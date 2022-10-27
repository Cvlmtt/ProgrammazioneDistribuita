import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    public String hello(String in) throws RemoteException;

}