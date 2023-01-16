package pl.put.poznan.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.logic.Building;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuildingControllerTest
{
    private BuildingController buildingController;
    private BuildingService mockObject;
    Building building;
    
    @BeforeEach
    void setUp()
    {
        mockObject = mock(BuildingService.class);
        buildingController = new BuildingController(mockObject);
    }

    @Test
    void getBuildings()
    {
        when(mockObject.getBuildings()).thenReturn(building);

        // Interakcja
        TestedClass testedObject = new TestedClass(mockObject);
        int result = testedObject.testedMethod("Something");

        // Weryfikacja
        // weryfikacja poprawności interakcji z obiektem zastępczym (Mockito)
        verify(mockObject).someMethod("Something")
        // weryfikacja kodu testowanego (JUnit)
        assertEquals(1, result);
    }

    @Test
    void getBuildingById()
    {
    }

    @Test
    void getFloorById()
    {
    }

    @Test
    void getRoomById()
    {
    }

    @Test
    void getOverheatedRooms()
    {
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