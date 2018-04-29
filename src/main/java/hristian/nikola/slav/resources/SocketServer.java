package hristian.nikola.slav.resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    private int port = 6350;
    private ServerSocket serverSocket;
    private Socket serviceSocket;

    public void startSocket() {
        try {
            serverSocket = new ServerSocket(port);
            serviceSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(serviceSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
            for(String input = in.readLine(); input != null; ) {
                out.println(input);
                System.out.println(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
