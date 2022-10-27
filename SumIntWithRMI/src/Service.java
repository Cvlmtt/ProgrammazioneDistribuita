import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    public void sum(int x) throws RemoteException;

    public int getValue() throws RemoteException;
}
