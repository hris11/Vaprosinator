package hristian.nikola.slav.resources;

import hristian.nikola.slav.Dto.UserDto;
import hristian.nikola.slav.models.User;
import hristian.nikola.slav.services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("player")
public class UserResource {

    private UserService userService = new UserService();

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public User createPlayer(UserDto data) {
        User us = new User(data.getNickname(), data.getEmail());
        userService.insert(us);
        return us;
    }

    @GET
    @Path("/{user_id}")
    @Produces("application/json")
    public User getPlayerInfo(@PathParam("user_id") Integer playerId) {
        return userService.getUser(playerId);
    }

    @POST
    @Path("/{user_id}/set-nickname")
    @Consumes("text/plain")
    @Produces("application/json")
    public User setUserNickname(@PathParam("user_id") Integer playerId, String nickname) {
       return userService.changeNickname(playerId, nickname);
    }

}
