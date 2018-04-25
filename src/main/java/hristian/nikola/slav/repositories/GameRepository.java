package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Game;
import org.hibernate.Session;

import java.util.List;

public class GameRepository {

    Session session = HibernateUtil.getSessionFactory().openSession();

    public Game getGameById(int id) {
        Game game = session.get(Game.class, id);
        return game;
    }

    public List<Game> getGames() {
        return null;
    }

    public Game createGame(Game game) {
        return null;
    }

    public Game updateGame(int id, Game game) {
        return null;
    }

    public void deleteGame(int id) {

    }
}
