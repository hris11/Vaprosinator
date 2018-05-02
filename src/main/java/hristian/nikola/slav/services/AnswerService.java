package hristian.nikola.slav.services;

import hristian.nikola.slav.models.Answer;
import hristian.nikola.slav.repositories.AnswerRepository;

import java.util.List;

public class AnswerService {
    private AnswerRepository answerRepository = new AnswerRepository();

    public Answer getCorrectAnswer(int questionId){
        return null;
    }

    public List<Answer> getQuestionAnswers(int questionId) {
        return answerRepository.getAnswers(questionId);
    }

    public List<Answer> createAnswers(List<Answer> answers, int questionId) {
        //set all as incorrect
        return null;
    }

    public  Answer setAnswerAsCorrect(int questionId, int answerId) {
        return null;
    }

    
}
