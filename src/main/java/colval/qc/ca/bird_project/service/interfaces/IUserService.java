package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Country;
import colval.qc.ca.bird_project.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User create(User Address);

    Optional<User> readOne(int Id);

    List<User> readAll();

    void delete(int Id);
}
