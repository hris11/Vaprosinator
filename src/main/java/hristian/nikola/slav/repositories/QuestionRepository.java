package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Question;
import org.hibernate.Session;

import java.util.List;

public class QuestionRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Question getQuestionById(int id) {
      return session.get(Question.class, id);
    }

    public List<Question> getQuestions() {
      return (List<Question>) session.createQuery("from Question").list();
    }

    public Question createQuestion(Question question) {
      session.beginTransaction();
      session.save(question);
      session.getTransaction().commit();
      return question;
    }

    public Question updateQuestion(int id, Question question) {
      session.beginTransaction();
      session.update(question);
      session.getTransaction().commit();
      return question;
    }

    public void deleteQuestion(int id) {
      session.beginTransaction();
      session.delete(getQuestionById(id));
      session.getTransaction().commit();
    }
}
