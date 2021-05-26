package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Country;
import colval.qc.ca.bird_project.model.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IUserService {
    User create(User Address);

    Optional<User> readOne(int Id);

    List<User> readAll();

    void update(int id ,User user);

    void delete(int Id);

    void updatePoints(int userId, int points);

    Optional<User> getUserByUserName(String username);

    Map<String, Double> getPercentageOfObservedBird(int Id);

    Map<String, Double> getPercentageOfObservedBird(User user);
}
