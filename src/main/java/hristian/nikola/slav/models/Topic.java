package hristian.nikola.slav.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "topic")
public class Topic {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column(name = "information")
    private String information;

    @Column(name = "game_id")
    private Integer gameId;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "topic_id")
    private List<Question> questions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Topic topic = (Topic) o;
        return Objects.equals(id, topic.id) &&
            Objects.equals(information, topic.information) &&
            Objects.equals(gameId, topic.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, information, gameId);
    }
}
