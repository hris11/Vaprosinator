package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Answer;
import org.hibernate.Session;

import java.util.List;

public class AnswerRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Answer getAnswerById(int id) {
        return null;
    }

    public List<Answer> getAnswers(int questId) {
        return null;
    }

    public void deleteAnswer(int id) {

    }

    public Answer updateAnswer(int id, Answer answer) {
        return null;
    }

    public Answer createAnswer(Answer answer) {
        return null;
    }
}
