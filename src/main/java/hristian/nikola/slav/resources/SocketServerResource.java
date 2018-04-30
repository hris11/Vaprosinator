package hristian.nikola.slav.resources;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/socket")
public class SocketServerResource {
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        if (message != null) {
            broadcast(message);
        }
    }

    @OnOpen
    public void onOpen(Session peer) throws IOException {
        System.out.println("connected " + peer.getId());
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) throws IOException {
        peers.remove(peer);
    }

    private static void broadcast(String message)
            throws IOException {

        peers.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}