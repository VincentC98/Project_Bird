package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Address;
import colval.qc.ca.bird_project.model.entities.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    Country create(Country Address);

    Optional<Country> readOne(int Id);

    List<Country> readAll();

    void delete(int Id);
}
