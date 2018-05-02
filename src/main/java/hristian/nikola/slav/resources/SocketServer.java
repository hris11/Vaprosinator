package hristian.nikola.slav.resources;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hristian.nikola.slav.models.Question;
import hristian.nikola.slav.services.AnswerService;
import hristian.nikola.slav.services.QuestionService;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class SocketServer extends WebSocketServer {

    private QuestionService questionService = new QuestionService();
    private AnswerService answerService = new AnswerService();
    private int p1;
    private int score = 0;

    public SocketServer(int port) {
        super(new InetSocketAddress(port));
    }

    public SocketServer(InetSocketAddress address) {
        super(address);
    }

    public static List<WebSocket> queue = new ArrayList<>();

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send( "new connection: " + handshake.getResourceDescriptor() );
        System.out.println( conn.getRemoteSocketAddress().getAddress().getHostAddress() + " established connection to server" );
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    }

    @Override
    public void onMessage(WebSocket conn, String message) {

        System.out.println("Message: " + message);
        Gson g = new Gson();
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        String event = jsonObject.get("event").getAsString();
        if (event.equals("queue")) {
            System.out.println(event);
            queue.add(conn);
            Thread t = new Thread(() -> {
               while(true) {
                   if (queue.size() >= 3 ) {
                       conn.send("{ \"start\" : \"start\"}");
                   }
                   break;
               }
            });
        }
        if (event.equals("question")) {
            System.out.println(event);
            Random rand = new Random();
            p1 = rand.nextInt(5);
            conn.send("{ \"question\" : \"" + questionService.getQuestion(p1) + "\", " +
                    "\"answers\" : \"" + answerService.getQuestionAnswers(p1));
        }
        if (event.equals("answer")) {
            System.out.println(event);
            if (jsonObject.get(event).equals(answerService.getQuestionAnswers(p1)))
            conn.send("{ \"message\" : \"stats\", \"p1\" : \"" + this.score + "\" }");
        }
        if (event.equals("end-game")) {
            System.out.println(event);
            conn.send("{ \"message\" : \"end\" }");
        }
    }

    @Override
    public void onMessage(WebSocket conn, ByteBuffer message ) {
        System.out.println(message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {

    }

    public void sendToAll(String text ) {
        Collection<WebSocket> con = connections();
        synchronized ( con ) {
            for( WebSocket c : con ) {
                c.send( text );
            }
        }
    }

    public void sendToList(List<String> players) {
        Collection<WebSocket> con = connections();
        for (String player : players) {

        }
    }

    public int getSocketCount() {
        return connections().size();
    }
}