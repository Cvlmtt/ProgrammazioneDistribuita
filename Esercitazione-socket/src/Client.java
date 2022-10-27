import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 60000);

        int x = new Random().nextInt(1, 200);

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(s.getInputStream());

        out.writeInt(x);
        out.flush();
        System.out.println("Sum= zucchero");
        int piselli=in.readInt();
        System.out.println("Sum="+piselli);
        s.close();
    }
}
