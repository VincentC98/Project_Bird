package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.Address;
import colval.qc.ca.bird_project.repositories.AddressRepository;
import colval.qc.ca.bird_project.service.interfaces.IAddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address Address) {
        return this.addressRepository.save(Address);
    }

    @Override
    public Optional<Address> readOne(int Id) {
        return Optional.empty();
    }

    @Override
    public List<Address> readAll() {
        return null;
    }

    @Override
    public void delete(int Id) {

    }
}
