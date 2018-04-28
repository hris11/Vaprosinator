package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Answer;
import org.hibernate.Session;

import java.util.List;

public class AnswerRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Answer getAnswerById(int id) {
      return session.get(Answer.class, id);
    }

    public List<Answer> getAnswers(int questId) {
        List<Answer> answers = session.createQuery("from Answer").list();
        return answers;
    }

    public void deleteAnswer(int id) {
        session.beginTransaction();
        session.delete(getAnswerById(id));
        session.getTransaction().commit();
    }

    public Answer updateAnswer(int id, Answer answer) {
        session.beginTransaction();
        session.update(answer);
        session.getTransaction().commit();
        return answer;
    }

    public Answer createAnswer(Answer answer) {
      session.beginTransaction();
      session.save(answer);
      session.getTransaction().commit();
      return answer;
    }
}
