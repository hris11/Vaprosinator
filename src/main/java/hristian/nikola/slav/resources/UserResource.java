package hristian.nikola.slav.resources;

import hristian.nikola.slav.Dto.PlayerDto;
import hristian.nikola.slav.models.ApplicationUser;
import hristian.nikola.slav.services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource {

    private UserService userService = new UserService();

    @POST
    public Response createPlayer() {
        ApplicationUser us = new ApplicationUser();
        userService.insert(us);
        return Response.ok().build();
    }

    @GET
    @Path("player/{player_id}")
    public PlayerDto getPlayerInfo(@PathParam("player_id") Integer playerId) {
        return new PlayerDto(1, "Sashko", 123);
    }


}
