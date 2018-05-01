package hristian.nikola.slav.services;

import hristian.nikola.slav.models.GameLog;
import hristian.nikola.slav.models.User;
import hristian.nikola.slav.repositories.GameLogRepository;
import hristian.nikola.slav.repositories.UserRepository;

import java.util.Comparator;
import java.util.List;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    private GameLogRepository gameLogRepository = new GameLogRepository();

    public User insert(User user) {
        if(getUserByEmail(user.getEmail()) == null) {
            return userRepository.createUser(user);
        }
        return getUserByEmail(user.getEmail());
    }

    public User getUser(int userId) {
        return userRepository.getUserById(userId);
    }

    public User getUserByEmail(String email) {
        return userRepository.checkIfExists(email);
    }

    public User joinLoby(int lobyId) {
        return null;
    }

    public User leaveLoby(int lobyId) {
        return null;
    }

    public User getInGame(int gameId) {
        return null;
    }

    public User changeNickname(int userId, String name) {
        User user = getUser(userId);
        user.setNickname(name);
        userRepository.updateUser(userId, user);
        return user;
    }

    public List<User> getTopTen() {
        List<User> users = userRepository.getUsers();
        users.sort((User u1, User u2) ->{
                if(u1.getWins().equals(u2.getWins()))
                    return 0;
                else if(u1.getWins() < u2.getWins())
                    return 1;
                else
                    return -1;
            }
        );
        if (users.size() <= 10) {
            return users;
        } else {
            return users.subList(0, 10);
        }
    }

    public List<GameLog> getPlayerGameLog(Integer userId) {
        return gameLogRepository.getPlayerGameLog(userId);
    }
}
