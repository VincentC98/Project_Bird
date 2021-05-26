package colval.qc.ca.bird_project.service.mapper;

import colval.qc.ca.bird_project.model.DTO.PostDTO;
import colval.qc.ca.bird_project.model.DTO.RegionDTO;
import colval.qc.ca.bird_project.model.entities.Post;
import colval.qc.ca.bird_project.model.entities.Region;
import colval.qc.ca.bird_project.service.impl.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionMapper implements EntityMapper<Region, RegionDTO>{
    @Autowired
    private RegionService regionService;
    @Override
    public RegionDTO entityToDto(Region region) {
        return new RegionDTO(
                region.getRegionId(),
                region.getName(),
                region.getSubName(),
                region.getCountry().getCountryId(),
                region.getCountry().getName(),
                region.getCountry().getSubName()
        );
    }

    @Override
    public Region DtoToEntity(RegionDTO regionDTO) {
        return this.regionService.readOne(regionDTO.getRegionId()).get();
    }
}
