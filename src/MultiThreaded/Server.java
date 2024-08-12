package MultiThreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    public Consumer<Socket> getConsumer()
    {
        return (clientSocket) -> {
            try
            {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the Server World");
                toClient.close();
                clientSocket.close();
            } catch(IOException e)
            {
                System.out.println(e.getMessage());
            }
        };
    }

    public static void main(String[] args) {
        int port = 8090;
        Server server = new Server();
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(20000);
            System.out.println("Server is listening on port: "+port);

            while(true)
            {
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }
        } catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
