package pl.put.poznan.transformer.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.transformer.logic.Building;
import pl.put.poznan.transformer.logic.Floor;
import pl.put.poznan.transformer.logic.Room;

import java.util.List;

/**
 * Class is used for Spring Application
 */
@RestController
@RequestMapping(path = "api/v1")
public class BuildingController {
    /**
     * This method is engaged in the maintenance of information for the application
     * @return list of building with information about their area, cube, heating, light
     */
    @GetMapping
    public List<Building> getBuilding() {
        Building building = new Building(1,"Willa");
        Floor floor = new Floor(1,"Carpet");
        Room room  = new Room(123, "bathroom", 5, 3, 25, 15);

        floor.add(room);
        building.add(floor);
        return List.of(building);
    }

}




