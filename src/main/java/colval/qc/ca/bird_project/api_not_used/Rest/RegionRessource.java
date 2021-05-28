package colval.qc.ca.bird_project.api_not_used.Rest;

import colval.qc.ca.bird_project.model.DTO.RegionDTO;
import colval.qc.ca.bird_project.model.entities.Region;
import colval.qc.ca.bird_project.service.impl.RegionService;
import colval.qc.ca.bird_project.service.mapper.RegionMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@RestController
//RequestMapping("/api/Region")
public class RegionRessource {
    private final RegionService regionService;
    private final RegionMapper regionMapper;

    public RegionRessource(RegionService regionService, RegionMapper regionMapper) {
        this.regionService = regionService;
        this.regionMapper = regionMapper;
    }

    @GetMapping("all")
    public ResponseEntity<?> getAll(){
        List<RegionDTO> regions = this.regionService.readAll().stream()
                .map(regionMapper::entityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(regions);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getPostWithId(@PathVariable int id) {
        Optional<Region> region = regionService.readOne(id);
        Optional<RegionDTO> regionDTO = region.stream()
                .map(regionMapper::entityToDto)
                .findFirst();
        return regionDTO.isPresent() ? ResponseEntity.ok()
                .header("Access-Control-Allow-Origin", "*")
                .body(regionDTO.get()) : new ResponseEntity<>("Customer Id not found", HttpStatus.NOT_FOUND);
    }
}
