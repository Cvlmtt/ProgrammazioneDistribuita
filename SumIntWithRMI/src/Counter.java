import java.io.Serial;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Counter extends UnicastRemoteObject implements Service, Serializable{
    public int counter;

    @Serial
    private static final long serialVersionUID = 1L;
    public Counter() throws RemoteException {
        counter=0;
    }
    @Override
    public void sum(int x) throws RemoteException {
        counter+=x;
    }

    @Override
    public int getValue() throws RemoteException {
        return counter;
    }
}
