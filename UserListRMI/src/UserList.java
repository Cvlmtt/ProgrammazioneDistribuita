import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserList extends Remote{
    public UserService addUser(String name, String surname, int age) throws RemoteException;
    public boolean delUser(UserService s) throws RemoteException;
}
