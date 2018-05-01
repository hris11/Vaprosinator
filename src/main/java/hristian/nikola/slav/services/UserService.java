package hristian.nikola.slav.services;

import hristian.nikola.slav.models.User;
import hristian.nikola.slav.repositories.UserRepository;
import org.hibernate.Session;

public class UserService {

    private UserRepository userRepository = new UserRepository();

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
}
