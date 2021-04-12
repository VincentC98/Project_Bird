package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Country;
import colval.qc.ca.bird_project.model.entities.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    Post create(Post Address);

    Optional<Post> readOne(int Id);

    List<Post> readAll();

    void delete(int Id);
}
