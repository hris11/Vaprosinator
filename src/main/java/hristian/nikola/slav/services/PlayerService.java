package hristian.nikola.slav.services;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Player;
import hristian.nikola.slav.repositories.PlayerRepository;
import org.hibernate.Session;

public class PlayerService {

    private PlayerRepository playerRepository = new PlayerRepository();

    public void insert(Player player) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(player);
        session.getTransaction().commit();
    }

}
