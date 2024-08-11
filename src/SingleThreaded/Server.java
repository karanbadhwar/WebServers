package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void run() throws IOException {
        int port = 8810;
        // This is same as Socket listening to any open requests
        ServerSocket socket = new ServerSocket(port);
        // Automatic closing of the socket after 10s
        socket.setSoTimeout(20000);

        while (true) {
            System.out.println("Server is listening on port " + port);
            // This part accepts the connection and returns a new Socket i.e. a created
            // socket through which they can exchange data
            Socket accepedtedConnection = socket.accept();
            System.out.println("Connection accepted from client " + accepedtedConnection.getRemoteSocketAddress());

            PrintWriter toClient = new PrintWriter(accepedtedConnection.getOutputStream(), true);
            BufferedReader fromClient = new BufferedReader(
                    new InputStreamReader(accepedtedConnection.getInputStream()));
            System.out.println(fromClient.readLine());

            toClient.println("Hello from the Server");

            toClient.close();
            fromClient.close();
            accepedtedConnection.close();
            
        }
        
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
