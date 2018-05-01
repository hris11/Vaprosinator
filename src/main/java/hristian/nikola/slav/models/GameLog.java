package hristian.nikola.slav.models;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "gamelog")
public class GameLog {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column(nullable = false, name = "game_id")
    private Integer gameId;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(nullable = false)
    private Date finishDate;

    @Column(name = "user_id")
    private Integer userId;

    @Column
    private Boolean won;

    @Column
    private Integer answeredQuestions;

    @Column
    private Integer mistakenQuestions;

    public GameLog() {
    }

    public GameLog(Integer gameId, Date finishDate, Integer userId, Boolean won, Integer answeredQuestions, Integer mistakenQuestions) {
        this.gameId = gameId;
        this.finishDate = finishDate;
        this.userId = userId;
        this.won = won;
        this.answeredQuestions = answeredQuestions;
        this.mistakenQuestions = mistakenQuestions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getWon() {
        return won;
    }

    public void setWon(Boolean won) {
        this.won = won;
    }

    public Integer getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(Integer answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public Integer getMistakenQuestions() {
        return mistakenQuestions;
    }

    public void setMistakenQuestions(Integer mistakenQuestions) {
        this.mistakenQuestions = mistakenQuestions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameLog gameLog = (GameLog) o;
        return Objects.equals(id, gameLog.id) &&
                Objects.equals(gameId, gameLog.gameId) &&
                Objects.equals(finishDate, gameLog.finishDate) &&
                Objects.equals(userId, gameLog.userId) &&
                Objects.equals(won, gameLog.won) &&
                Objects.equals(answeredQuestions, gameLog.answeredQuestions) &&
                Objects.equals(mistakenQuestions, gameLog.mistakenQuestions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, gameId, finishDate, userId, won, answeredQuestions, mistakenQuestions);
    }
}
