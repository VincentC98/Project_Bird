package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Country;
import colval.qc.ca.bird_project.model.entities.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    Post create(Post Address);

    Optional<Post> readOne(int Id);

    List<Post> readAll();

    void update(int id, Post post);

    void delete(int Id);

    double gePostRateAverage(int id);

    double gePostRateAverage(Post post);

    int getTotalOfPost();
}
