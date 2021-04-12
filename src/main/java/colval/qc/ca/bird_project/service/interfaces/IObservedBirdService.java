package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Country;
import colval.qc.ca.bird_project.model.entities.ObservedBird;

import java.util.List;
import java.util.Optional;

public interface IObservedBirdService {
    ObservedBird create(ObservedBird Address);

    Optional<ObservedBird> readOne(int Id);

    List<ObservedBird> readAll();

    void delete(int Id);
}
