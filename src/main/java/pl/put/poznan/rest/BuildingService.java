package pl.put.poznan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.Floor;
import pl.put.poznan.logic.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BuildingService {
    private final BuildingRepository buildingRepository;
    private final FloorRepository floorRepository;
    private final RoomRepository roomRepository;

    private final LocationRepository locationRepository;

    @Autowired
    public BuildingService(BuildingRepository buildingRepository, FloorRepository floorRepository, RoomRepository roomRepository, LocationRepository locationRepository) {
        this.buildingRepository = buildingRepository;
        this.floorRepository = floorRepository;
        this.roomRepository = roomRepository;

        this.locationRepository = locationRepository;
    }

    public List<Building> getBuildings() {
        return buildingRepository.findAll();
    }

    public void insertBuilding(Building building) {
        buildingRepository.save(building);
    }

    public void insertFloorIntoBuilding(Floor floor, int id) {
        if (buildingRepository.findById(id).isPresent()) {
            Building building = buildingRepository.findById(id).get();
            floor.setBuilding(building);
            building.addFloor(floor);
            floorRepository.save(floor);
        } else {
            throw new NoSuchElementException();
        }

    }

    public void insertRoomIntoFloor(Room room, int id) {
        if (floorRepository.findById(id).isPresent()) {
            Floor floor = floorRepository.findById(id).get();
            room.setFloor(floor);
            floor.addRoom(room);
            roomRepository.save(room);
        } else {
            throw new NoSuchElementException();
        }
    }


    public Building getBuildingById(int id) {
        Building building = null;
        if(buildingRepository.findById(id).isPresent()) {
            building = buildingRepository.findById(id).get();
        }
        return building;

    }

    public Floor getFloorById(int id) {
        Floor floor = null;
        if(floorRepository.findById(id).isPresent()) {
            floor = floorRepository.findById(id).get();
        }
        return floor;

    }

    public Room getRoomById(int id) {
        Room room = null;
        if(roomRepository.findById(id).isPresent()) {
            room = roomRepository.findById(id).get();
        }
        return room;

    }

    public void deleteBuildingById(int id) {
        boolean exists = buildingRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("building does not exists");
        }
        buildingRepository.deleteById(id);
    }

    public void deleteFloorById(int id) {
        System.out.println("Usuwanie pietra");
        boolean exists = floorRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("floor does not exists");
        }
        Floor floor = null;
        if(floorRepository.findById(id).isPresent()) {
            floor = floorRepository.findById(id).get();
            Building b = floor.getBuilding();
            b.getFloors().remove(floor);
            floor.setBuilding(null);
            floorRepository.delete(floor);
        }

    }

    public void deleteRoomById(int id) {
        System.out.println("Usuwanie pietra");
        boolean exists = roomRepository.existsById(id);
        if (!exists) {
            throw new IllegalArgumentException("floor does not exists");
        }
        Room room = null;
        if (roomRepository.findById(id).isPresent()) {
            room = roomRepository.findById(id).get();
            Floor f = room.getFloor();
            f.getRooms().remove(room);
            room.setFloor(null);
            roomRepository.deleteById(id);
        }
    }

    public List<Room> getOverheatedRooms(int id, int value) {
        List<Room> overHeatedRooms = new ArrayList<>();
        Building building = null;
        if(buildingRepository.findById(id).isPresent()) {
            building = buildingRepository.findById(id).get();
        }

        if (building != null) {
            for (Floor f : building.getFloors()) {
                for (Room r : f.getRooms()) {
                    if (r.heatingLevel(value)) {
                        overHeatedRooms.add(r);
                    }
                }
            }
        }

        return overHeatedRooms;
    }

    public void updateBuilding(int id, Building building) {
        Building b = buildingRepository.findById(id).get();
        b.setName(building.getName());
        buildingRepository.save(b);
    }

    public void updateFloor(int id, Floor floor) {
        Floor f = floorRepository.findById(id).get();
        f.setName(floor.getName());
        floorRepository.save(f);
    }

    public void updateRoom(int id, Room room) {
        Room r = roomRepository.findById(id).get();
        r.updateRoom(room);
        roomRepository.save(r);
    }
}