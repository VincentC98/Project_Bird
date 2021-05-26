package colval.qc.ca.bird_project;

import colval.qc.ca.bird_project.model.entities.*;
import colval.qc.ca.bird_project.repositories.RegionRepository;
import colval.qc.ca.bird_project.service.impl.RegionService;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegionTest {
    /*private final RegionService regionService = new RegionService()

        @Test
    public void GetBirdsCountInSpecificRegionTest(){
        List<ObservedBird> observedBirds = new ArrayList<ObservedBird>(Arrays.asList(new ObservedBird(1, "Cardinal", new Region())
                ,new ObservedBird(1, "Cardinal", new Region()), new ObservedBird(1, "Cardinal", new Region()), new ObservedBird(1, "Blue Jay", new Region()),
                new ObservedBird(1, "Blue Jay", new Region()), new ObservedBird(1, "Chickadee", new Region())));
        Region region = new Region(1,"Quebec","QC", observedBirds,new ArrayList<Address>(),new Country());

        Map<String, Integer> BirdCount = this.re.GetBirdsCountInSpecificRegion(region);

        String birdName = "Cardinal";
        String birdNameFromEntry = "";

        for (Map.Entry<String, Integer> bird: BirdCount.entrySet()){
            birdNameFromEntry = bird.getKey();
            break;
        }

        assertThat(birdName).isEqualTo(birdNameFromEntry);
    }*/
}
