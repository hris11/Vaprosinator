package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Topic;
import org.hibernate.Session;

import java.util.List;

public class TopicRepository {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    public Topic getTopicById(int id) {
        return session.get(Topic.class, id);
    }

    public List<Topic> getTopics() {
        return (List<Topic>) session.createQuery("from Topic").list();
    }

    public Topic createTopic(Topic topic) {
        session.beginTransaction();
        session.save(topic);
        session.getTransaction().commit();
        return topic;
    }

    public Topic updateTopic(int id, Topic topic) {
        session.beginTransaction();
        session.update(topic);
        session.getTransaction().commit();
        return topic;
    }

    public void deleteTopic(int id) {
        session.beginTransaction();
        session.delete(getTopicById(id));
        session.getTransaction().commit();
    }
}
