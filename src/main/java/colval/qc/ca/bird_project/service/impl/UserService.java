package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.User;
import colval.qc.ca.bird_project.repositories.UserRepository;
import colval.qc.ca.bird_project.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User create(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> readOne(int Id) {
        return userRepository.findById(Id);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(int Id) {
        userRepository.deleteById(Id);
    }
}
