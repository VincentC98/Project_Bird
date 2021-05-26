package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Address;
import colval.qc.ca.bird_project.model.entities.Rate;

import java.util.List;
import java.util.Optional;

public interface IRateService {
    Rate create(Rate rate);

    Optional<Rate> readOne(int Id);

    List<Rate> readAll();

    void delete(int Id);

    int addPoint(double rate);
}
