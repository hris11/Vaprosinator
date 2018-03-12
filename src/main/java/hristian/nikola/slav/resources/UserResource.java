package hristian.nikola.slav.resources;

import hristian.nikola.slav.models.User;
import hristian.nikola.slav.services.UserService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("player")
public class UserResource {

    private UserService userService = new UserService();

    @POST
    public Response createPlayer(User user) {
        userService.insert(user);
        return Response.ok().build();
    }
}
