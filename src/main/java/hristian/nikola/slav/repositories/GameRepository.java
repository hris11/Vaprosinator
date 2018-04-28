package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Game;
import org.hibernate.Session;

import java.util.List;

public class GameRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Game getGameById(int id) {
        return session.get(Game.class, id);
    }

    public List<Game> getGames() {
        return (List<Game>) session.createQuery("from Game").list();
    }

    public Game createGame(Game game) {
        session.beginTransaction();
        session.save(game);
        session.getTransaction().commit();
        return game;
    }

    public Game updateGame(int id, Game game) {
        session.beginTransaction();
        session.update(game);
        session.getTransaction().commit();
        return game;
    }

    public void deleteGame(int id) {
        session.beginTransaction();
        session.delete(getGameById(id));
        session.getTransaction().commit();
    }
}
