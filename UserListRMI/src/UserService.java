import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote{
    public void addString(String s) throws RemoteException;
    public int delString(String s) throws RemoteException;
    public ArrayList<String> getList() throws RemoteException;
    public void setName(String s) throws RemoteException;
    public String getName() throws RemoteException;
    public void setSurname(String s) throws RemoteException;
    public String getSurname() throws RemoteException;
    public void setAge(int age) throws RemoteException;
    public int getAge() throws RemoteException;
    public int getId() throws RemoteException;
}
