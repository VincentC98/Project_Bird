package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.repositories.PostRepository;
import colval.qc.ca.bird_project.service.interfaces.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post create(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public Optional<Post> readOne(int Id) {
        return Optional.empty();
    }

    @Override
    public List<Post> readAll() {
        return this.postRepository.findAll();
    }

    @Override
    public void delete(int Id) {

    }
}
