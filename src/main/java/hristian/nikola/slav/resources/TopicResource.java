package hristian.nikola.slav.resources;

import hristian.nikola.slav.models.Topic;
import hristian.nikola.slav.services.TopicService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("topic")
public class TopicResource {

  private TopicService topicService = new TopicService();

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Topic createTopic(Topic topic) {
    Topic top = new Topic();
    top.setInformation(topic.getInformation());
    return topicService.createTopic(top);
  }

  @GET
  @Produces("application/json")
  public List<Topic> getAllTopics() {
    return topicService.getTopics();
  }
}
