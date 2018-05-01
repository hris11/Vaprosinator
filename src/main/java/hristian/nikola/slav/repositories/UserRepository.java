package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.User;
import javax.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class UserRepository {
    private Session session = HibernateUtil.getSessionFactory().openSession();

    public User getUserById(int id) {
        return session.get(User.class, id);
    }

    public List<User> getUsers() {
        return (List<User>) session.createQuery("from User").list();
    }

    public User createUser(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return user;
    }

    public User updateUser(int id, User user) {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        return user;
    }

    public void deleteUser(int id) {
        session.beginTransaction();
        session.delete(getUserById(id));
        session.getTransaction().commit();
    }

    public User checkIfExists(String email) {
        session.beginTransaction();
        User user;
        Query query = session.createQuery("from User where email = :email");
        query.setParameter("email", email);
        List<?> list = query.getResultList();
        session.getTransaction().commit();
        if (!list.isEmpty()) {
            user = (User)list.get(0);
        } else {
            return null;
        }
        return user;
    }
}
