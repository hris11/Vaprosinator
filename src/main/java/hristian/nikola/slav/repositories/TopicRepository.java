package hristian.nikola.slav.repositories;

import hristian.nikola.slav.config.HibernateUtil;
import hristian.nikola.slav.models.Topic;
import org.hibernate.Session;

import java.util.List;

public class TopicRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public Topic getTpicById(int id) {
        return null;
    }

    public List<Topic> getTopics() {
        return null;
    }

    public Topic createTopic(Topic topic) {
        return null;
    }

    public Topic updateTopic(int id, Topic topic) {
        return null;
    }

    public void deleteTopic(int id) {

    }
}
