package pl.put.poznan.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.Floor;
import pl.put.poznan.logic.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuildingControllerTest
{
    private BuildingController buildingController;
    private BuildingService mockBuildingService;
    private Building building;
    
    @BeforeEach
    void setUp()
    {
        mockBuildingService = mock(BuildingService.class);

        Building building1 = new Building(1, "Building 1");
        Building building2 = new Building(2, "Building 2");
        building = new Building(3, "Building");

        Floor floor1 = new Floor(3, "Carpet");
        Floor floor2 = new Floor(4, "Restaurant");
        Floor floor3 = new Floor(-1, "Fake floor");



        Room room1 = new Room(10, "Bedroom", 25, 85, 25, 40);
        Room room2 = new Room(11, "Toilet", 15, 10, 11, 10);
        Room room3 = new Room(12, "Kitchen", 40, 160, 45, 150);
        Room room4 = new Room(13, "Fake room", 1, -1, 1, -1);


        floor1.addRoom(room1);
        floor1.addRoom(room2);
        floor1.addRoom(room3);
        building1.addFloor(floor1);

        List<Building> mockBuildings = Arrays.asList(building1, building2);
        when(mockBuildingService.getBuildings()).thenReturn(mockBuildings);
        buildingController = new BuildingController(mockBuildingService);

    }

    @Test
    void getBuildings()
    {
        List<Building> buildings = buildingController.getBuildings();
        assertEquals(2, buildings.size());
    }

    @Test
    void getBuildingById()
    {
        Building building = new Building(1, "Building 1");
        when(mockBuildingService.getBuildingById(1)).thenReturn(building);
        when(mockBuildingService.getBuildingById(10)).thenReturn(null);
        Building result1 = buildingController.getBuildingById(1);
        Building result2 = buildingController.getBuildingById(10);
        assertEquals(building, result1);
        assertNull(result2);
    }

    @Test
    void getFloorById()
    {
        Floor floor = new Floor(4, "Pietro");
        when(mockBuildingService.getFloorById(4)).thenReturn(floor);

        Floor result = buildingController.getFloorById(4);
        assertEquals(floor, result);

    }

    @Test
    void getRoomById()
    {
        Room room = new Room(3, "Kuchnia");
        when(mockBuildingService.getRoomById(3)).thenReturn(room);

        Room result = buildingController.getRoomById(3);
        assertEquals(room, result);
    }

    @Test
    void getOverheatedRooms()
    {
        Building building1 = buildingController.getBuildings().get(0);
        Room room1 = new Room(143, "Toilet", 15, 10, 11, 10);
        Room room2 = new Room(3, "Toilet", 15, 10, 101, 10);
        Room room3 = new Room(100, "Toilet", 15, 1000, 101, 10);

        List<Room> overHeatedRooms = List.of(room1, room3);
        when(mockBuildingService.getOverheatedRooms(1, 1)).thenReturn(overHeatedRooms);
        List<Room> result = buildingController.getOverheatedRooms(1, 1);
        assertEquals(overHeatedRooms, result);
    }

    @Test
    void insertBuilding()
    {

        

    }

    @Test
    void insertFloor()
    {
    }

    @Test
    void insertRoom()
    {
    }

    @Test
    void deleteBuildingById()
    {
    }

    @Test
    void deleteFloorById()
    {
    }

    @Test
    void deleteRoomById()
    {
    }

    @Test
    void updateBuilding()
    {
    }

    @Test
    void updateFloor()
    {
    }

    @Test
    void updateRoom()
    {
    }
}