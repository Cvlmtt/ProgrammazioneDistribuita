import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server starting...");

        ServerSocket server = new ServerSocket(60000);
        Socket socket = server.accept();

        InputStream is = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);

        OutputStream os = socket.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

        //read
        int i1 = ois.readInt();
        int i2 = ois.readInt();

        int sum = i1 + i2;
        System.out.println("Sum done!");

        //write
        oos.writeInt(sum);
        oos.flush();

        socket.close();

        server.close();
    }
}
