package hristian.nikola.slav.resources;

import hristian.nikola.slav.models.Question;
import hristian.nikola.slav.services.QuestionService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("question")
public class QuestionResource {

  private QuestionService questionService = new QuestionService();

  @POST
  @Consumes("application/json")
  @Produces("application/json")
  public Question createQuestion(Question question) {
    return questionService.addQuestion(question);
  }

  @GET
  @Produces("application/json")
  public List<Question> getAllQuestions(){
    return questionService.getQuestions();
  }

}
