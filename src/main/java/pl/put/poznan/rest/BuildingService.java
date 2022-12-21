package pl.put.poznan.rest;

import org.springframework.stereotype.Service;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.BaseLocation;
import pl.put.poznan.logic.Room;

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

    public BaseLocation getLocationById(int id) {
       return buildingRepository.getLocationById(id);

    }

    public List<Room> getOverheatedRooms(int id, int value) {
        return buildingRepository.getOverheatedRooms(id, value);
    }
}
