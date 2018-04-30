package hristian.nikola.slav.services;

import hristian.nikola.slav.exeption.ResourceNotFoundException;
import hristian.nikola.slav.models.Game;
import hristian.nikola.slav.models.User;

import hristian.nikola.slav.repositories.GameRepository;
import java.util.List;

public class GameService {
    private TopicService topicService;
    private QuestionService questionService;
    private UserService userService;
    private GameRepository gameRepository;

    public Boolean getGameState(int gameId) throws ResourceNotFoundException {
        Game game = gameRepository.getGameById(gameId);
        if (game.getOver() == null) {
            throw new ResourceNotFoundException("game hast started yet.");
        }
        return null;
    }

    public Game createGame(Game game) {
        gameRepository.createGame(game);
        return game;
    }
    public Game endGame() {
        return null;
    }

    public Game startGame() {
        return null;
    }

    public Game setTopic() {
        return null;
    }

    public List<User> getPlayers() {
        return null;
    }

    public List<User> joinPlayers() {
        return null;
    }

    public Game joinLoby(User user) {
        return null;
    }

    public Game leaveLoby(User user) {
        return null;
    }
}
