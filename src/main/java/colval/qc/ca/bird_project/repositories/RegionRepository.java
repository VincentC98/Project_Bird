package colval.qc.ca.bird_project.repositories;

import colval.qc.ca.bird_project.model.entities.Region;
import colval.qc.ca.bird_project.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Integer> {
}
