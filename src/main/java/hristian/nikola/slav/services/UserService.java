package hristian.nikola.slav.services;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.ApplicationUser;
import hristian.nikola.slav.models.User;
import hristian.nikola.slav.repositories.UserRepository;
import org.hibernate.Session;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public void insert(ApplicationUser user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
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
        return null;
    }
}
