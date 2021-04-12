package colval.qc.ca.bird_project.service.interfaces;

import colval.qc.ca.bird_project.model.entities.Address;

import java.util.List;
import java.util.Optional;

public interface IAddressService {
    Address create(Address Address);

    Optional<Address> readOne(int Id);

    List<Address> readAll();

    void delete(int Id);
}
