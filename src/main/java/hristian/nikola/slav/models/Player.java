package hristian.nikola.slav.models;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player")
public class Player {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "ingamename")
    private String inGameName;

    public Player(String username, String password, String inGameName) {
        this.username = username;
        this.password = password;
        this.inGameName = inGameName;
    }

    public Player() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInGameName() {
        return inGameName;
    }

    public void setInGameName(String inGameName) {
        this.inGameName = inGameName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id) &&
                Objects.equals(username, player.username) &&
                Objects.equals(password, player.password) &&
                Objects.equals(inGameName, player.inGameName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, inGameName);
    }
}
