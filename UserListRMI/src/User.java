import java.io.Serial;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class User extends UnicastRemoteObject implements UserService, Serializable{
    public String name;
    public String surname;
    public int age;

    public static int id;
    public ArrayList<String> stringList;

    @Serial
    private static final long serialVersionUID = 1L;

    public User(String name, String surname, int age) throws RemoteException {
        this.name=name;
        this.surname=surname;
        this.age=age;
        this.stringList = new ArrayList<>();
        this.id = id + 1;
    }

    public User() throws RemoteException {

    }

    public String getName() throws RemoteException {
        return name;
    }

    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public String getSurname() throws RemoteException {
        return surname;
    }

    public void setSurname(String surname) throws RemoteException {
        this.surname = surname;
    }

    public int getAge() throws RemoteException {
        return age;
    }

    public void setAge(int age) throws RemoteException {
        this.age = age;
    }

    public int getId() throws RemoteException{
        return id;
    }

    @Override
    public void addString(String s) throws RemoteException {
        stringList.add(s);
    }

    @Override
    public int delString(String s) throws RemoteException {
        if(stringList.remove(s))
            return 0;
        else return 1;
    }

    @Override
    public ArrayList<String> getList() throws RemoteException {
        return stringList;
    }
}
