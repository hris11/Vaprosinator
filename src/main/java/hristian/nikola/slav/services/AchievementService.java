package hristian.nikola.slav.services;

import hristian.nikola.slav.models.Achievement;

import hristian.nikola.slav.models.User;
import hristian.nikola.slav.repositories.AchievementRepository;
import hristian.nikola.slav.repositories.UserRepository;
import java.util.List;

public class AchievementService {

    private AchievementRepository achievementRepository;
    private UserRepository userRepository;

    public List<Achievement> getAchievements() {
        return achievementRepository.getAllAchievements();
    }

    public List<Achievement> getPlayerAchievemnts(int playerId) {
        User user = userRepository.getUserById(playerId);
        return user.getAchievements();
    }

    public Achievement completeAchievement(int playerId, int achievementId) {
        return null;
    }

    public Achievement createAchievements(int playerId) {
        //add incomplete achievements to a player
        return null;
    }

    public List<Achievement> getPlayerCompleteAchievements(int playerId) {
        return null;
    }

    public List<Achievement> getPlyaerIncompleteAchievements(int playerId) {
        return null;
    }
}
