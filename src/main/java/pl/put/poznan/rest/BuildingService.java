package pl.put.poznan.rest;

import org.springframework.stereotype.Service;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.Location;

import java.util.List;

@Service
public class BuildingService {

    private final RepositoryHolder repositoryHolder = RepositoryHolder.getInstance();
    private final BuildingRepository buildingRepository;

    public BuildingService() {
        repositoryHolder.setBuildingRepository(new BuildingRepository());
        buildingRepository = repositoryHolder.getBuildingRepository();
    }

    public List<Building> getBuildings() {
        return buildingRepository.getBuildings();
    }

    public void insertBuilding(Building building) {
        buildingRepository.insertBuilding(building);
    }

    public void deleteLocation(int id) {
        buildingRepository.deleteLocationById(id);
    }

    public Location getLocationById(int id) {
       return buildingRepository.getLocationById(id);

    }
}
