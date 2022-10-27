import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Server {
    protected Server() throws RemoteException{
    }

    public static void main(String[] args) throws MalformedURLException,RemoteException {
        System.out.println("Avvio server...");
        Server s = new Server();
        ArrayList<User> userList = new ArrayList<>();
        Users list = new Users(userList);
        Naming.rebind("UserList", list);
        System.out.println("...Servizio registrato");
    }
}
