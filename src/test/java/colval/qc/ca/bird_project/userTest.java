package colval.qc.ca.bird_project;

import colval.qc.ca.bird_project.model.entities.*;
import colval.qc.ca.bird_project.repositories.UserRepository;
import colval.qc.ca.bird_project.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.*;

public class userTest {

    /*UserService userService = new UserService(new UserRepository() {
        @Override
        public List<User> findAll() {
            return null;
        }

        @Override
        public List<User> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<User> findAllById(Iterable<Integer> iterable) {
            return null;
        }

        @Override
        public <S extends User> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends User> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<User> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public User getOne(Integer integer) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<User> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> S save(S s) {
            return null;
        }

        @Override
        public Optional<User> findById(Integer integer) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Integer integer) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Integer integer) {

        }

        @Override
        public void delete(User user) {

        }

        @Override
        public void deleteAll(Iterable<? extends User> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends User> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends User> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends User> boolean exists(Example<S> example) {
            return false;
        }
    });

    @Test
    void testBirdPercentages(){
        Post post = new Post(1,"test","test",new Date(),"test",new ArrayList<Rate>(),new ObservedBird(1,"Cardinal", new Region()), new User());
        Post post1 = new Post(1,"test","test",new Date(),"test",new ArrayList<Rate>(),new ObservedBird(2,"Cardinal", new Region()), new User());
        Post post2 = new Post(1,"test","test",new Date(),"test",new ArrayList<Rate>(),new ObservedBird(3,"Cardinal", new Region()), new User());
        User user = new User(1, "Vincent", "Chartier", "vinc", "123", "Homme", "vincent.chartier@mail.com", new Date(), "111-111-1111",0, new ArrayList<Post>(Arrays.asList(post, post1, post2)), new Address());
        double percentage = 100;
        double birdPercentage = 0;
        Map<String, Double> birdPercentages = userService.getPercentageOfObservedBird(user);
        Iterator iterator = birdPercentages.entrySet().iterator();
        while (iterator.hasNext()){
            birdPercentage = ((Map.Entry<String, Double>)iterator.next()).getValue();
        }

        assertThat(birdPercentage).isEqualTo(percentage);
    }*/
}
