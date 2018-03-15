package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Achievement;
import org.hibernate.Session;

import java.util.List;

public class AchievementRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Achievement getAchievementById(int id) {
        return null;
    }

    public Achievement createAchievemnt(Achievement achievement) {
        return null;
    }

    public List<Achievement> getAchievements(int userId) {
        return null;
    }

    public Achievement updateAchievemnt(int id, Achievement achievement) {
        return null;
    }

    public void deleteAchievement(int id) {

    }
}
