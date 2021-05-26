package colval.qc.ca.bird_project;

import colval.qc.ca.bird_project.model.entities.ObservedBird;
import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.model.entities.Rate;
import colval.qc.ca.bird_project.model.entities.User;
import colval.qc.ca.bird_project.repositories.PostRepository;
import colval.qc.ca.bird_project.service.impl.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostTest {

    private PostService postService = new PostService(new PostRepository() {
        @Override
        public List<Post> findAll() {
            return null;
        }

        @Override
        public List<Post> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<Post> findAllById(Iterable<Integer> iterable) {
            return null;
        }

        @Override
        public <S extends Post> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends Post> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<Post> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public Post getOne(Integer integer) {
            return null;
        }

        @Override
        public <S extends Post> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Post> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Post> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Post> S save(S s) {
            return null;
        }

        @Override
        public Optional<Post> findById(Integer integer) {
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
        public void delete(Post post) {

        }

        @Override
        public void deleteAll(Iterable<? extends Post> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Post> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Post> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Post> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Post> boolean exists(Example<S> example) {
            return false;
        }
    });

    @Test
    void testRateAvg(){
        double avg = 3;
        Rate rate = new Rate(1, 3, new Post());
        Rate rate1 = new Rate(2, 3, new Post());
        Rate rate2 = new Rate(3, 3, new Post());
        Post post = new Post(1,"test","test",new Date(),"test",new ArrayList<Rate>(Arrays.asList(rate, rate1, rate2)),new ObservedBird(), new User());
        double postAvg = postService.gePostRateAverage(post);
        assertThat(postAvg).isEqualTo(avg);
    }
}
