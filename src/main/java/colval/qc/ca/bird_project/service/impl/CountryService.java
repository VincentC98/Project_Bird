package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.Country;
import colval.qc.ca.bird_project.repositories.CountryRepository;
import colval.qc.ca.bird_project.service.interfaces.ICountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {
        return this.countryRepository.save(country);
    }

    @Override
    public Optional<Country> readOne(int Id) {
        return Optional.empty();
    }

    @Override
    public List<Country> readAll() {
        return null;
    }

    @Override
    public void delete(int Id) {

    }
}
