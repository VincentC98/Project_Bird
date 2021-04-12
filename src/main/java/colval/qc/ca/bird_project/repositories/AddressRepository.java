package colval.qc.ca.bird_project.repositories;

import colval.qc.ca.bird_project.model.entities.Address;
import colval.qc.ca.bird_project.model.entities.ObservedBird;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
