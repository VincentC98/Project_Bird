package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Country;

import colval.qc.ca.bird_project.model.entities.Region;
import java.util.List;
import java.util.Optional;

public interface IRegionService {
    Region create(Region Address);

    Optional<Region> readOne(int Id);

    List<Region> readAll();

    void delete(int Id);
}
