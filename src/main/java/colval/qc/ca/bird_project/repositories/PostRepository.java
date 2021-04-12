package colval.qc.ca.bird_project.repositories;

import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
