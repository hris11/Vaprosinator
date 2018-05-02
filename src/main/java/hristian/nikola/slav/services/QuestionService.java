package hristian.nikola.slav.services;

import hristian.nikola.slav.models.Question;

import hristian.nikola.slav.repositories.QuestionRepository;
import java.util.List;

public class QuestionService {

    private QuestionRepository questionRepository = new QuestionRepository();

    public List<Question> getQuestions() {
        return questionRepository.getQuestions();
    }

    public Question getQuestion(int questionId) {
        return questionRepository.getQuestionById(questionId);
    }

    public Question addQuestion(Question question) {
        return questionRepository.createQuestion(question);
    }
}
