package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.model.entities.Rate;
import colval.qc.ca.bird_project.repositories.PostRepository;
import colval.qc.ca.bird_project.service.interfaces.IPostService;
import org.springframework.stereotype.Service;

import java.util.Date;
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
        return postRepository.findById(Id);
    }

    @Override
    public List<Post> readAll() {
        return this.postRepository.findAll();
    }

    @Override
    public void update(int id,Post post) {
        System.out.println("update on service" + post.getPostId());
        Optional<Post> storedOptional = readOne(id);

        if (storedOptional.isPresent()) {
            Post stored = storedOptional.get();

            Date now = new Date();

            stored.setTitle(post.getTitle());
            stored.setDescription(post.getDescription());

            postRepository.save(stored);
        }
    }

    @Override
    public void delete(int Id) {
        this.postRepository.deleteById(Id);
    }


    //retourne la moyenne des cotes du posts
    @Override
    public double gePostRateAverage(int id) {
        Optional<Post> post = this.postRepository.findById(id);
        double totalRate = 0;
        int totalNumberOfRate = post.get().getRate().size();
        double avgRate = 0;
        if (post.get().getRate().isEmpty()){
            return 0.0;
        }
        else{
            for (Rate rate : post.get().getRate()){
                totalRate += rate.getRate();
            }
        }
        avgRate = totalRate/totalNumberOfRate;
        return  avgRate;
    }

    //même chose pour l'autre. Utilisé comme test unitaire.
    @Override
    public double gePostRateAverage(Post post) {
        double totalRate = 0;
        int totalNumberOfRate = post.getRate().size();
        double avgRate = 0;
        for (Rate rate : post.getRate()){
            totalRate += rate.getRate();
        }
        avgRate = totalRate/totalNumberOfRate;
        return  avgRate;
    }

    @Override
    public int getTotalOfPost() {
        return this.postRepository.findAll().size();
    }
}
