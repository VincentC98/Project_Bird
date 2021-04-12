package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.repositories.RegionRepository;
import colval.qc.ca.bird_project.service.interfaces.IRegionService;
import org.springframework.stereotype.Service;


import colval.qc.ca.bird_project.model.entities.Region;
import java.util.List;
import java.util.Optional;

@Service
public class RegionService implements IRegionService {
    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }


    @Override
    public Region create(Region region) {
        return this.regionRepository.save(region);
    }

    @Override
    public Optional<Region> readOne(int Id) {
        return this.regionRepository.findById(Id);
    }

    @Override
    public List<Region> readAll() {
        return this.regionRepository.findAll();
    }

    @Override
    public void delete(int Id) {
        this.regionRepository.deleteById(Id);
    }
}
