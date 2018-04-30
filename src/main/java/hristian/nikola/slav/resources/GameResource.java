package hristian.nikola.slav.resources;

import hristian.nikola.slav.exeption.ResourceNotFoundException;
import hristian.nikola.slav.models.Game;
import hristian.nikola.slav.services.GameService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("game")
public class GameResource {

  private GameService gameService = new GameService();

  @GET
  public void startSocket() {
    Thread t = new Thread(() -> {
      try {
        SocketServerResource.run();
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    t.start();
  }

  @GET
  @Produces("application/json")
  @Path("is-game-over/{gameId}")
  public Boolean getGameState(@PathParam("gameId") int gameId ) throws ResourceNotFoundException {
    Boolean state = gameService.getGameState(gameId);
    return state;
  }

}
