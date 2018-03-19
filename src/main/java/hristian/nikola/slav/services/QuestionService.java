package hristian.nikola.slav.services;

import hristian.nikola.slav.models.Question;

import java.util.List;

public class QuestionService {
    private List<Question> questionList;

    public QuestionService() {
        questionList = getQuestions();
    }

    private List<Question> getQuestions() {
        return null;
    }

    public Question getQuestion(int questionId) {
        return null;
    }

    public Question addQuestion(Question question) {
        return null;
    }

    public List<Question> updateQuestionList() {
        //add more questions to the question list
        return null;
    }
}
