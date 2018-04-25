package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class UserRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public User getUserById(int id) {
        User user = session.get(User.class, id);
        return user;
    }

    public List<User> getUsers() {
        return null;
    }

    public User createUser(User user) {
        return null;
    }

    public User updateUser(int id, User user) {
        return null;
    }

    public void deleteUser(int id) {

    }
}
