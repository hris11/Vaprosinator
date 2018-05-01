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

    @Column
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "game_id")
    private Integer gameId;

    @Column
    private Integer wins;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<ApplicationUser> applicationUser;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private List<GameLog> gameLogs;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "users")
    @JoinTable(
        name = "User_Achievement",
        joinColumns = { @JoinColumn(name = "user_id") },
        inverseJoinColumns = { @JoinColumn(name = "achievement_id") }
    )
    private List<Achievement> achievements;

    public User(String email, String nickname, Integer gameId, Integer wins, List<ApplicationUser> applicationUser, List<GameLog> gameLogs, List<Achievement> achievements) {
        this.email = email;
        this.nickname = nickname;
        this.gameId = gameId;
        this.wins = wins;
        this.applicationUser = applicationUser;
        this.gameLogs = gameLogs;
        this.achievements = achievements;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public List<ApplicationUser> getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(List<ApplicationUser> applicationUser) {
        this.applicationUser = applicationUser;
    }

    public List<GameLog> getGameLogs() {
        return gameLogs;
    }

    public void setGameLogs(List<GameLog> gameLogs) {
        this.gameLogs = gameLogs;
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
                Objects.equals(email, user.email) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(gameId, user.gameId) &&
                Objects.equals(wins, user.wins) &&
                Objects.equals(applicationUser, user.applicationUser) &&
                Objects.equals(gameLogs, user.gameLogs) &&
                Objects.equals(achievements, user.achievements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, nickname, gameId, wins, applicationUser, gameLogs, achievements);
    }
}
