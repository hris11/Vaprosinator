package hristian.nikola.slav.resources;

import java.io.*;

public class SocketServerResource {
    public static SocketServer server;

    public static void run() throws IOException, InterruptedException {
        int port = 9090;

        server = new SocketServer( port );

        server.start();
        System.out.println("Socket Server started on port: " + server.getPort());

        BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String in = sysin.readLine();
            server.sendToAll(in);
            if (in.equals("exit")) {
                server.stop();
                break;
            }
            if (in.equals("count")) {
                System.out.println(server.getSocketCount());
            }
        }
    }
}