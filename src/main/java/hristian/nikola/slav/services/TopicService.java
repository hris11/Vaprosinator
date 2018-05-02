package hristian.nikola.slav.services;

import hristian.nikola.slav.models.Topic;

import hristian.nikola.slav.repositories.TopicRepository;
import java.util.List;

public class TopicService {
    private TopicRepository topicRepository = new TopicRepository();

    public List<Topic> getTopics() {
        return topicRepository.getTopics();
    }

    public Topic createTopic(Topic topic) {
        return topicRepository.createTopic(topic);
    }

    public Topic chosenGameTopic(Topic topic, int gameId) {
        return null;
    }
}
