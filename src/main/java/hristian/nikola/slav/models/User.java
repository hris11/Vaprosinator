package hristian.nikola.slav.models;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "player")
public class User {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "game_id")
    private Integer gameId;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<UserInformation> userInformations;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<ApplicationUser> applicationUser;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "users")
    private List<Achievement> achievements;

    public User(String nickname, Integer gameId, List<ApplicationUser> applicationUser) {
        this.nickname = nickname;
        this.gameId = gameId;
        this.applicationUser = applicationUser;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public List<UserInformation> getUserInformations() {
        return userInformations;
    }

    public void setUserInformations(
        List<UserInformation> userInformations) {
        this.userInformations = userInformations;
    }

    public List<ApplicationUser> getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(
        List<ApplicationUser> applicationUser) {
        this.applicationUser = applicationUser;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(gameId, user.gameId) &&
                Objects.equals(applicationUser, user.applicationUser);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nickname, gameId, applicationUser);
    }
}
