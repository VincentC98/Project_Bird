package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.ObservedBird;
import colval.qc.ca.bird_project.repositories.ObservedBirdRepository;
import colval.qc.ca.bird_project.service.interfaces.IObservedBirdService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObservedBirdService implements IObservedBirdService {
    private final ObservedBirdRepository observedBirdRepository;

    public ObservedBirdService(ObservedBirdRepository observedBirdRepository) {
        this.observedBirdRepository = observedBirdRepository;
    }

    @Override
    public ObservedBird create(ObservedBird observedBird) {
        return this.observedBirdRepository.save(observedBird);
    }

    @Override
    public Optional<ObservedBird> readOne(int Id) {
        return Optional.empty();
    }

    @Override
    public List<ObservedBird> readAll() {
        return this.observedBirdRepository.findAll();
    }

    @Override
    public void delete(int Id) {
        this.observedBirdRepository.deleteById(Id);
    }
}
