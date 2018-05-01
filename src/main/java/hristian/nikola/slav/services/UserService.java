package hristian.nikola.slav.services;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.ApplicationUser;
import hristian.nikola.slav.models.GameLog;
import hristian.nikola.slav.models.User;
import hristian.nikola.slav.repositories.GameLogRepository;
import hristian.nikola.slav.repositories.UserRepository;
import org.hibernate.Session;

import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    private GameLogRepository gameLogRepository = new GameLogRepository();

    public void insert(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
    public User getUser(int userId) {
        return userRepository.getUserById(userId);
    }

    public User joinLoby(int lobyId) {
        return null;
    }

    public User leaveLoby(int lobyId) {
        return null;
    }

    public User getInGame(int gameId) {
        return null;
    }

    public User changeNickname(int userId, String name) {
        User user = getUser(userId);
        user.setNickname(name);
        userRepository.updateUser(userId, user);
        return user;
    }

    public List<GameLog> getPlayerGameLog(Integer userId) {
        return gameLogRepository.getPlayerGameLog(userId);
    }
}
