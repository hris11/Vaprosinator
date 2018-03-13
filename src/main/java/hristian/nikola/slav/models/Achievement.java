package hristian.nikola.slav.models;

import javax.swing.text.StyledEditorKit.BoldAction;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "achievement")
public class Achievement {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column(name = "goal")
    private String goal;

    @Column
    private Boolean completed;

    @ManyToMany(mappedBy = "achievements")
    private List<User> users;

    public Achievement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Achievement that = (Achievement) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(goal, that.goal) &&
            Objects.equals(completed, that.completed) &&
            Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goal, completed, users);
    }
}
