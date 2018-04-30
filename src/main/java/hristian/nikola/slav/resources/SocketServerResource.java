package hristian.nikola.slav.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

@Path("socket")
public class SocketServerResource {
    private int port = 6350;
    private ServerSocket serverSocket;
    private Socket serviceSocket;

    @GET
    public void startSocket() {
        try {
            serverSocket = new ServerSocket(port, 1 , InetAddress.getLocalHost());
            serviceSocket = serverSocket.accept();
            System.out.println(serviceSocket.getInetAddress().getHostAddress());
            PrintWriter out = new PrintWriter(serviceSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
            String data;
            while ( (data = in.readLine()) != null ) {
                System.out.println("\r\nMessage from : " + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
