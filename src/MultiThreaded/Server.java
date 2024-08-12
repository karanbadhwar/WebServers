package MultiThreaded;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8090;
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.getSoTimeout();
            System.out.println("Server is listening on port: "+port);

            while(true)
            {
                Socket acceptedSocket = serverSocket.accept();
            }
        } catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
