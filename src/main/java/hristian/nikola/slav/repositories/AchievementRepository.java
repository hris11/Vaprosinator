package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Achievement;
import hristian.nikola.slav.models.Game;
import java.rmi.activation.ActivationID;
import org.hibernate.Session;

import java.util.List;

public class AchievementRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Achievement getAchievementById(int id) {
        Achievement achievement = session.get(Achievement.class, id);
        return achievement;
    }

    public Achievement createAchievemnt(Achievement achievement) {
      session.beginTransaction();
      session.save(achievement);
      session.getTransaction().commit();
      return achievement;
    }

    public List<Achievement> getAchievements(int userId) {
      List<Achievement> achievements  = session.createQuery("from Achievement").list();
      return achievements;
    }

    public Achievement updateAchievemnt(int id, Achievement achievement) {
      session.beginTransaction();
      session.update(achievement);
      session.getTransaction().commit();
      return achievement;
    }

    public void deleteAchievement(int id) {
      session.beginTransaction();
      session.delete(getAchievementById(id));
      session.getTransaction().commit();
    }
}
