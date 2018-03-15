package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Question;
import org.hibernate.Session;

import java.util.List;

public class QuestionRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public Question getQuestionById(int id) {
        return null;
    }

    public List<Question> getQuestions() {
        return null;
    }

    public Question createQuestion(Question question) {
        return null;
    }

    public Question updateQuestion(int id, Question question) {
        return null;
    }

    public void deleteQuestion(int id) {

    }
}
