package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.Rate;
import colval.qc.ca.bird_project.repositories.RateRepository;
import colval.qc.ca.bird_project.service.interfaces.IRateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RateService implements IRateService {
    private final RateRepository rateRepository;

    public RateService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }

    @Override
    public Rate create(Rate rate) {
        return this.rateRepository.save(rate);
    }

    @Override
    public Optional<Rate> readOne(int Id) {
        return this.rateRepository.findById(Id);
    }

    @Override
    public List<Rate> readAll() {
        return this.rateRepository.findAll();
    }

    @Override
    public void delete(int Id) {
        this.rateRepository.deleteById(Id);
    }

    @Override
    public int addPoint(double rate) {
        int points = 0;

        if (rate == 1){
            points = 1;
        }
        if (rate == 2){
            points = 1;
        }
        if (rate == 3){
            points = 2;
        }
        if (rate == 4){
            points = 2;
        }
        if (rate == 5){
            points = 3;
        }

        return points;
    }
}
