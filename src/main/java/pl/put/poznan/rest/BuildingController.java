package pl.put.poznan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.BaseLocation;
import pl.put.poznan.logic.Room;

import java.util.List;

/**
 * Class is used for Spring Application
 */
@RestController
@RequestMapping(path = "api/v1")
public class BuildingController {
    private final BuildingService buildingService;

    @Autowired
    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }

    /**
     * This method is engaged in the maintenance of information for the application
     * @return list of building with information about their area, cube, heating, light
     */
    @GetMapping(path = "buildings")
    public List<Building> getBuildings() {

        return buildingService.getBuildings();
    }

    @GetMapping(path = "location/{id}")
    public BaseLocation getLocationById(@PathVariable("id") int id) {
        return buildingService.getLocationById(id);
    }

    @PostMapping
    public void insertBuilding(@RequestBody Building building) {
        buildingService.insertBuilding(building);
    }

    @DeleteMapping(path = "{id}")
    public void deleteLocation(@PathVariable("id") int id) {
        buildingService.deleteLocation(id);
    }

//    @GetMapping(path = "overheating/{id}/{value}")
//    public List<Room> getOverheatedRooms(@PathVariable("id", "value") int value) {
//        return buildingService.getOverheatedRooms(value);
//    }
}




