import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Users extends UnicastRemoteObject implements UserList{
    public ArrayList<User> list;

    public Users(ArrayList<User> list) throws RemoteException{
        this.list = list;
    }

    private User getUser(int id) throws RemoteException {
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id)
                    return list.get(i);
        }
        return null;
    }

    @Override
    public UserService addUser(String name, String surname, int age) throws RemoteException {
        User u = new User(name, surname, age);
        list.add(u);
        UserService service = (UserService) u;
        return service;
    }

    @Override
    public boolean delUser(UserService s) throws RemoteException {
        return list.remove(getUser(s.getId()));
    }
}
