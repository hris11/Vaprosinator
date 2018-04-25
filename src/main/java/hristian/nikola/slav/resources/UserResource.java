package hristian.nikola.slav.resources;

import hristian.nikola.slav.Dto.PlayerDto;
import hristian.nikola.slav.models.ApplicationUser;
import hristian.nikola.slav.models.User;
import hristian.nikola.slav.services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource {

    private UserService userService = new UserService();

    @POST
    public Response createPlayer() {
        User us = new User();
        us.setNickname("nikolaeqk");
        userService.insert(us);
        return Response.ok().build();
    }

    @GET
    @Path("player/{player_id}")
    @Produces("application/json")
    public User getPlayerInfo(@PathParam("player_id") Integer playerId) {
        return userService.getUser(playerId);
    }


}
