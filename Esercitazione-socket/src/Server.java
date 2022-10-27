import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    Contatore contatore;
    Socket s;

    public Server(Contatore contatore, Socket s){
        this.contatore = contatore;
        this.s = s;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Server partito");

        ServerSocket ss = new ServerSocket(60000);

        System.out.println("server accetta");


        Contatore conta = new Contatore();
        while(true) {
            Socket s = ss.accept();
            Server server = new Server(conta, s);

            Thread thrd = new Thread(server);
            System.out.println("server crea thread");

            thrd.start();

        }
    }

    @Override
    public void run() {
        try {
            System.out.println("thread partito");
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            int x = in.readInt();
            System.out.println("thread letto "+x);
            contatore.incrementa(x);
            System.out.println("thread incrementa");
            int zaino=contatore.getValue();
            out.writeInt(zaino);
            out.flush();
            System.out.println("thread scritto "+contatore.getValue());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
