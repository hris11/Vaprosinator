package hristian.nikola.slav.resources;

import hristian.nikola.slav.models.User;
import hristian.nikola.slav.services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("leaderboard")
public class LeaderboardResource {
    private UserService userService = new UserService();

    @GET
    @Produces("application/json")
    public List<User> getLeaderboard() {
        return userService.getTopTen();
    }
}
