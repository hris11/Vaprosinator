package hristian.nikola.slav.models;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

public class Answer {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column
    private String content;

    @Column(columnDefinition = "default 'false'")
    private Boolean correct;

    @Column(name = "question_id")
    private Integer questionId;

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