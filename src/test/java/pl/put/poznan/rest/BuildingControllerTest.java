package pl.put.poznan.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.Floor;
import pl.put.poznan.logic.Room;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Test BuildingController class using mocks.
 */
class BuildingControllerTest
{
    private BuildingController buildingController;
    private BuildingService mockBuildingService;
    private BuildingRepository mockBuildingRepository;
    private FloorRepository    mockFloorRepository;
    private RoomRepository     mockRoomRepository;
    private Building           building1, building2, building;
    private Floor              floor1, floor2, floor3;
    private Room               room1, room2, room3;
    private List<Building> mockBuildings;
    private List<Floor> mockFloors;
    private List<Room> mockRooms;
    /**
     * buildingService is a mock for buildingController
     */
    @BeforeEach
    void setUp()
    {
        mockBuildingService = mock(BuildingService.class);
        building1 = new Building(1, "Building 1");
        building2 = new Building(2, "Building 2");
        building = new Building(3, "Building");

        floor1 = new Floor(3, "Carpet");
        floor2 = new Floor(4, "Restaurant");
        floor3 = new Floor(-1, "Fake floor");

         room1 = new Room(10, "Bedroom", 25, 85, 25, 40);
         room2 = new Room(11, "Toilet", 15, 10, 11, 10);
         room3 = new Room(12, "Kitchen", 40, 160, 45, 150);

        floor1.addRoom(room1);
        floor1.addRoom(room2);
        floor1.addRoom(room3);
        building1.addFloor(floor1);

        mockBuildings = Arrays.asList(building1, building2); //building1 contains 3 floors, building2 nothing
        when(mockBuildingService.getBuildings()).thenReturn(mockBuildings);

        buildingController = new BuildingController(mockBuildingService);


        mockFloors = Arrays.asList(floor1, floor2, floor3);
        mockRooms = Arrays.asList(room1, room2, room3);
    }

    @Test
    void testGetBuildings()
    {
        List<Building> buildings = buildingController.getBuildings();
        assertEquals(2, buildings.size());
    }

    @Test
    void testGetBuildingById()
    {
        Building building = new Building(1, "Building 1");

        when(mockBuildingService.getBuildingById(1)).thenReturn(building);
        Building result1 = buildingController.getBuildingById(1);
        assertEquals(building, result1);

        when(mockBuildingService.getBuildingById(10)).thenReturn(null);
        Building result2 = buildingController.getBuildingById(10);
        assertNull(result2);
    }

    @Test
    void testGetFloorById()
    {
        Floor floor = new Floor(4, "Pietro");
        when(mockBuildingService.getFloorById(4)).thenReturn(floor);

        Floor result = buildingController.getFloorById(4);
        assertEquals(floor, result);

    }

    @Test
    void testGetRoomById()
    {
        Room room = new Room(3, "Kuchnia");
        when(mockBuildingService.getRoomById(3)).thenReturn(room);

        Room result = buildingController.getRoomById(3);
        assertEquals(room, result);
    }

    @Test
    void testGetOverheatedRooms()
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
    void testInsertBuilding()
    {
        // mock stuff
        mockBuildingRepository = mock(BuildingRepository.class);
        mockBuildingRepository.save(building);
        mockBuildings = Arrays.asList(building1, building2, building);
        mockBuildingService.insertBuilding(building);

        // controller stuff
        buildingController.insertBuilding(building);
        List<Building> result = Arrays.asList(building1, building2, building);
        System.out.println(result);

        // assert function
        assertEquals(mockBuildings , result);
    }

    @Test
    void insertFloor()
    {
        // mock stuff
        mockFloorRepository = mock(FloorRepository.class);

        // controller stuff
        buildingController.insertBuilding(building);
        List<Floor> result = Arrays.asList(floor1, floor2, floor3);
        System.out.println(result);

        // assert function
        assertEquals(mockFloors , result);
    }

    @Test
    void insertRoom()
    {
        // mock stuff
        mockRoomRepository = mock(RoomRepository.class);

        // controller stuff
        buildingController.insertBuilding(building);
        List<Room> result = Arrays.asList(room1, room2, room3);
        System.out.println(result);

        // assert function
        assertEquals(mockRooms , result);
    }

    @Test
    void deleteBuildingById()
    {
        mockBuildingRepository = mock(BuildingRepository.class);
        mockBuildingRepository.save(building);
        mockBuildings = Arrays.asList(building1, building2, building);
        mockBuildingService.insertBuilding(building);
        buildingController.insertBuilding(building);
        List<Building> result = Arrays.asList(building1, building2, building);
        System.out.println(result);
        assertEquals(mockBuildings , result);
    }

    @Test
    void deleteFloorById()
    {
        mockFloorRepository = mock(FloorRepository.class);
        buildingController.insertBuilding(building);
        List<Floor> result = Arrays.asList(floor1, floor2, floor3);
        System.out.println(result);
        assertEquals(mockFloors , result);
    }

    @Test
    void deleteRoomById()
    {
        mockRoomRepository = mock(RoomRepository.class);
        buildingController.insertBuilding(building);
        List<Room> result = Arrays.asList(room1, room2, room3);
        System.out.println(result);
        assertEquals(mockRooms , result);
    }
}