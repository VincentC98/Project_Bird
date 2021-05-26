package colval.qc.ca.bird_project.repositories;

import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.model.entities.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RateRepository extends JpaRepository<Rate, Integer> {
}
