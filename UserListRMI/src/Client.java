import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        System.out.println("Avvio client...");
        UserList list = (UserList) Naming.lookup("rmi://localhost/UserList");
        System.out.println("Inserisci nome: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Inserisci cognome: ");
        String surname = new Scanner(System.in).nextLine();
        System.out.println("Inserisci età: ");
        int age= new Scanner(System.in).nextInt();

        UserService s = (UserService) list.addUser(name, surname, age);

        boolean loop = true;
        while(loop){
            System.out.println("Benvenuto "+s.getName()+" "+s.getSurname());
            System.out.println("Inserisci l'operazione che vuoi effettuare:\n" +
                    "add: aggiungi una stringa alla tua lista\n" +
                    "delete: rimuovi una stringa dalla tua lista\n" +
                    "list: mostra la tua lista di stringhe\n" +
                    "exit: chiudere la connessione");
            String choose = new Scanner(System.in).nextLine();
            switch (choose) {
                case "add": {
                    System.out.println("Inserisci la stringa da aggiungere: ");
                    String str = new Scanner(System.in).nextLine();
                    s.addString(str);
                    break;
                }
                case "delete": {
                    System.out.println("Inserisci la stringa da rimuovere: ");
                    String str = new Scanner(System.in).nextLine();
                    s.delString(str);
                    break;
                }
                case "list": {
                    System.out.println("Ecco la tua lista di stringhe: ");
                    ArrayList<String> strList = s.getList();
                    System.out.println(strList.toString());
                    break;
                }
                case "exit": {
                    list.delUser(s);
                    loop = false;
                    break;
                }
                default: {
                    System.out.println("...connection closed");
                    loop = false;
                    break;
                }
            }
        }
        list.delUser(s);
    }
}
