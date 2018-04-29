package hristian.nikola.slav.resources;

import hristian.nikola.slav.Dto.UserDto;
import hristian.nikola.slav.models.User;
import hristian.nikola.slav.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource {

    private UserService userService = new UserService();

    @POST
    @Consumes("application/json")
    public Response createPlayer(UserDto data) {
        User us = new User(data.getNickname(), data.getEmail(), data.getUsername());
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
