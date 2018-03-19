package hristian.nikola.slav.models;

import java.util.Objects;
import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "answer")
public class Answer {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column
    private String content;

    @Column
    private Boolean correct;

    @Column(name = "question_id")
    private Integer questionId;

    public Answer(String content, Boolean correct, Integer questionId) {
        this.content = content;
        this.correct = correct;
        this.questionId = questionId;
    }

    public Answer() {
    }

    public Integer getId() {
      return id;
    }

    public void setId(Integer id) {
      this.id = id;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public Boolean getCorrect() {
      return correct;
    }

    public void setCorrect(Boolean correct) {
      this.correct = correct;
    }

    public Integer getQuestionId() {
      return questionId;
    }

    public void setQuestionId(Integer questionId) {
      this.questionId = questionId;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Answer answer = (Answer) o;
    return Objects.equals(id, answer.id) &&
        Objects.equals(content, answer.content) &&
        Objects.equals(correct, answer.correct) &&
        Objects.equals(questionId, answer.questionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, content, correct, questionId);
  }
}
