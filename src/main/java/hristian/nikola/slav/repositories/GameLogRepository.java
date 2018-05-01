package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.GameLog;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GameLogRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();


    public List<GameLog> getPlayerGameLog(Integer userId) {
        List<GameLog> result = new ArrayList<>();
        session.beginTransaction();

        result = session.createQuery("from GameLog where user_id = :user_id", GameLog.class)
                .setParameter("user_id", userId)
                .getResultList();

        session.getTransaction().commit();
        return result;
    }
}
