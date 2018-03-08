package hristian.nikola.slav.resources;

import hristian.nikola.slav.models.Player;
import hristian.nikola.slav.services.PlayerService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("player")
public class PlayerResource {

    private PlayerService playerService = new PlayerService();

    @POST
    public Response createPlayer(Player player) {
        playerService.insert(player);
        return Response.ok().build();
    }
}
