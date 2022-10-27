import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Client starting");

        Socket socket = new Socket("localhost", 60000);

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        //write
        int i1 = 10;
        int i2 = 42;

        oos.writeInt(i1);
        oos.writeInt(i2);
        oos.flush();

        //read
        int result = ois.readInt();
        oos.flush();
        System.out.println("Result: "+result);
        socket.close();
    }
}
