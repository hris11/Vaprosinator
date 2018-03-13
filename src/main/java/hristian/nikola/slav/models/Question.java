package hristian.nikola.slav.models;

import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
    @JsonIgnore
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;

    @Column
    private String question;

    @Column(name = "correct_answer")
    private String correctAnswer;

    @Column(name = "wrong_answers")
    private List<String> wrongAnswers;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Topic questionTopic;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(List<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public Topic getQuestionTopic() {
        return questionTopic;
    }

    public void setQuestionTopic(Topic questionTopic) {
        this.questionTopic = questionTopic;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question1 = (Question) o;
        return Objects.equals(id, question1.id) &&
            Objects.equals(question, question1.question) &&
            Objects.equals(correctAnswer, question1.correctAnswer) &&
            Objects.equals(wrongAnswers, question1.wrongAnswers) &&
            Objects.equals(questionTopic, question1.questionTopic) &&
            Objects.equals(answers, question1.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, correctAnswer, wrongAnswers, questionTopic, answers);
    }
}
