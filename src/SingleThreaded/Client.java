package SingleThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public void run() throws UnknownHostException, IOException
    {
        int port = 8810;
        InetAddress address = InetAddress.getByName("localhost");

        //Creating Client side socket to start communication
        Socket socket = new Socket(address, port);

        PrintWriter toServer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        toServer.println("Hello from the client");

        String line = fromServer.readLine();

        System.out.println("Response from the Server is: "+line);

        toServer.close();
        fromServer.close();
        socket.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try
        {
            client.run();
        } catch(Exception e)
        {
            e.printStackTrace();
            
        }
    }
}
