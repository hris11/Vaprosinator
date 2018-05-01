package hristian.nikola.slav.config;

import hristian.nikola.slav.resources.SocketServerResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;

@ApplicationPath("api")
public class ApplicationConfig extends Application {
    private static SocketServerResource socketServerResource;
    private Thread thread;

    public ApplicationConfig() {
        thread = new Thread(() -> {
            try {
                socketServerResource.run();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
