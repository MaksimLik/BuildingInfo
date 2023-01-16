package pl.put.poznan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.BaseLocation;
import pl.put.poznan.logic.Floor;
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



    @GetMapping(path = "buildings")
    public List<Building> getBuildings() {
        return buildingService.getBuildings();
    }

    @GetMapping(path = "building/{id}")
    public Building getBuildingById(@PathVariable("id") int id) {
        return buildingService.getBuildingById(id);
    }

    @GetMapping(path = "floor/{id}")
    public Floor getFloorById(@PathVariable("id") int id) {
        return buildingService.getFloorById(id);
    }

    @GetMapping(path = "room/{id}")
    public Room getRoomById(@PathVariable("id") int id) {
        return buildingService.getRoomById(id);
    }


    @GetMapping(path = "overheating/{id}/{value}")
    public List<Room> getOverheatedRooms(@PathVariable int id, @PathVariable int value ) {
        return buildingService.getOverheatedRooms(id, value);
    }


    @PostMapping(path = "building")
    public void insertBuilding(@RequestBody Building building) {
        buildingService.insertBuilding(building);
    }

    @PostMapping(path = "building/{id}/floor")
    public void insertFloor(@RequestBody Floor floor, @PathVariable("id") int id) {
        buildingService.insertFloorIntoBuilding(floor, id);
    }

    @PostMapping(path = "floor/{id}/room")
    public void insertRoom(@RequestBody Room room, @PathVariable("id") int id) {
        buildingService.insertRoomIntoFloor(room, id);
    }



    @DeleteMapping(path = "building/{id}")
    public void deleteBuildingById(@PathVariable("id") int id) {
         buildingService.deleteBuildingById(id);
    }

    @DeleteMapping(path = "floor/{id}")
    public void deleteFloorById(@PathVariable("id") int id) {
         buildingService.deleteFloorById(id);
    }

    @DeleteMapping(path = "room/{id}")
    public void deleteRoomById(@PathVariable("id") int id) {
         buildingService.deleteRoomById(id);
    }



    @PatchMapping(path = "building/{id}")
    public void updateBuilding(@PathVariable("id") int id, @RequestBody Building building) {
        buildingService.updateBuilding(id, building);
    }

    @PatchMapping(path = "floor/{id}")
    public void updateFloor(@PathVariable("id") int id, @RequestBody Floor floor) {
        buildingService.updateFloor(id, floor);
    }

    @PatchMapping(path = "room/{id}")
    public void updateRoom(@PathVariable("id") int id, @RequestBody Room room) {
        buildingService.updateRoom(id, room);
    }

}





