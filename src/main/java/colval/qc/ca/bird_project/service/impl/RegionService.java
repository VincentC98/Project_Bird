package colval.qc.ca.bird_project.service.impl;

import colval.qc.ca.bird_project.model.entities.ObservedBird;
import colval.qc.ca.bird_project.repositories.RegionRepository;
import colval.qc.ca.bird_project.service.interfaces.IRegionService;
import org.springframework.stereotype.Service;


import colval.qc.ca.bird_project.model.entities.Region;

import java.util.*;

@Service
public class RegionService implements IRegionService {
    private final RegionRepository regionRepository;
    private final ObservedBirdService observedBirdService;

    public RegionService(RegionRepository regionRepository, ObservedBirdService observedBirdService) {
        this.regionRepository = regionRepository;
        this.observedBirdService = observedBirdService;
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

    //retourn le nombre d'un espèce d'oiseau dans une région spécifique
    @Override
    public Map<String, Integer> GetBirdsCountInSpecificRegion(int regionId) {
        Optional<Region> region = this.regionRepository.findById(regionId);
        Map<String, Integer> birdCount = new HashMap<String, Integer>();
        List<ObservedBird> observedBirds = region.get().getBirds();

        if (observedBirds.isEmpty()){
            return null;
        }

        birdCount = fillMap( birdCount,observedBirds);

        birdCount = addCounts(birdCount, observedBirds);

        birdCount = sortBirdCount(birdCount);

        return birdCount;
    }

    //même chose pour l'autre. test unitaire.
    @Override
    public Map<String, Integer> GetBirdsCountInSpecificRegion(Region region) {
        Map<String, Integer> birdCount = new HashMap<String, Integer>();
        List<ObservedBird> observedBirds = region.getBirds();

        birdCount = fillMap( birdCount,observedBirds);

        birdCount = addCounts(birdCount, observedBirds);

        birdCount = sortBirdCount(birdCount);

        return birdCount;
    }

    //trie le dictionnaire selon le nombre d'espèce d'oiseau
    private Map<String, Integer> sortBirdCount(Map<String, Integer> birdCount) {
        List<Map.Entry<String, Integer>> birdCountList = new LinkedList<>(birdCount.entrySet());

        birdCountList.sort((count1, count2) -> count2.getValue() - count1.getValue());

        return birdCount;
    }

    //ajoute le nombre d'espèce d'oiseau dans le dictionnaire avec le région spécifié
    private Map<String, Integer> addCounts(Map<String, Integer> birdCount, List<ObservedBird> observedBirds) {Map<String, Double> birdPercentages = new HashMap<String, Double>();
        int countSpecificBird = 0;

        for (Map.Entry<String, Integer> count : birdCount.entrySet()){
            countSpecificBird = 0;
            for (ObservedBird observedBird: observedBirds){
                System.out.println("for observedBirds: " + observedBird.getName());
                System.out.println("for map: " + count.getKey());
                if (observedBird.getName().equals(count.getKey())){
                    System.out.println("is counted");
                    countSpecificBird++;
                }
            }

            count.setValue(countSpecificBird);
        }

        return birdCount;
    }

    //construit le dictionnaire
    private Map<String, Integer> fillMap(Map<String, Integer> birdCount, List<ObservedBird> observedBirds) {
        boolean isFoundBird = false;
        boolean nobirdCountAdded = true;
        for (ObservedBird observedBird: observedBirds){
            if(nobirdCountAdded){
                birdCount.put(observedBird.getName(), 0);
                nobirdCountAdded = false;
            }
            else {
                for (String bird : birdCount.keySet()){
                    if (observedBird.getName() == bird){
                        isFoundBird = true;
                        break;
                    }
                }
                if(isFoundBird){
                    isFoundBird = false;
                    continue;
                } else {
                    birdCount.put(observedBird.getName(), 0);
                }
            }
        }

        return birdCount;
    }
}
