package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.model.entities.User;
import colval.qc.ca.bird_project.repositories.UserRepository;
import colval.qc.ca.bird_project.service.interfaces.IUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

@Service
public class UserService implements IUserService, UserDetailsService {
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
    public void update(int id ,User user) {
        System.out.println(user);
        Optional<User> storedOptional = this.userRepository.findById(user.getId());

        if (storedOptional.isPresent()) {
            System.out.println("proceed update");
            User stored = storedOptional.get();

            stored.setFirstName(user.getFirstName());
            stored.setLastName(user.getLastName());
            stored.setUserName(user.getUserName());
            stored.setPassword(user.getPassword());
            stored.setGender(user.getGender());
            stored.setEmailAddress(user.getEmailAddress());
            stored.setBirthDate(user.getBirthDate());
            stored.setPhone(user.getPhone());
            stored.setAddress(user.getAddress());
            stored.setPoints(user.getPoints());

            userRepository.save(stored);
        }
    }

    @Override
    public void delete(int Id) {
        userRepository.deleteById(Id);
    }

    @Override
    public void updatePoints(int userId, int points) {
        User user = this.userRepository.getOne(userId);

        user.setPoints(user.getPoints() + points);

        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByUserName(String username) {
        return this.userRepository.findByUserName(username);
    }

    @Override
    public Map<String, Double> getPercentageOfObservedBird(int Id) {
        Map<String, Double> birdPercentages;
        List<Post> posts = this.userRepository.findById(Id).get().getPosts();

        birdPercentages = fillMap(posts);

        birdPercentages = addPercentages(birdPercentages, posts);

        return birdPercentages;
    }

    @Override
    public Map<String, Double> getPercentageOfObservedBird(User user) {
        Map<String, Double> birdPercentages;
        List<Post> posts = user.getPosts();

        birdPercentages = fillMap(posts);

        birdPercentages = addPercentages(birdPercentages, posts);

        return birdPercentages;
    }

    private Map<String, Double> fillMap(List<Post> posts){
        Map<String, Double> birdPercentages = new HashMap<String, Double>();
        boolean isFoundBird = false;
        boolean noBirdPercentageAdded = true;
        for (Post post: posts){
            if(noBirdPercentageAdded){
                birdPercentages.put(post.getBird().getName(), 0.0);
                noBirdPercentageAdded = false;
            }
            else {
                for (String bird : birdPercentages.keySet()){
                    if (post.getBird().getName() == bird){
                        isFoundBird = true;
                        break;
                    }
                }
                if(isFoundBird){
                    isFoundBird = false;
                    continue;
                } else {
                    birdPercentages.put(post.getBird().getName(), 0.0);
                }
            }
        }

        return birdPercentages;
    }

    private Map<String, Double> addPercentages(Map<String, Double> birdPercentages, List<Post> posts){
        int totalOfPost = posts.size();
        int countSpecificBird = 0;
        double percentage = 0.0;

        for (Map.Entry<String, Double> birdPercentage : birdPercentages.entrySet()){
            countSpecificBird = 0;
            for (Post post: posts){
                if (post.getBird().getName() == birdPercentage.getKey()){
                    countSpecificBird++;
                }
            }
            percentage = (countSpecificBird*100)/totalOfPost;
            birdPercentage.setValue(percentage);
        }

        return birdPercentages;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s).get();
        if (user == null) {
            throw new UsernameNotFoundException("No user found with username: " + s);
        }
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<GrantedAuthority>());
    }
}
