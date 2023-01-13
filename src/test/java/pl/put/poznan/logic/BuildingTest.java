package pl.put.poznan.logic;

import org.apache.tomcat.util.digester.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {
    Building building1, building2, building3;

    Floor floor1, floor2, floor3, floor4;
    Room room1, room2, room3, room4, room5, room6, room7, room8, room9, room10;
    ArrayList<Floor> building1Floors, building2Floors, building3Floors;
    ArrayList<Room> building1Rooms, building2Rooms, building3Rooms;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws Exception  {
        building1 = new Building(1,"Zamek");
        building2 = new Building(2,"Willa");
        building3 = new Building(3,"Schowek");

        floor1 = new Floor(3, "Carpet");
        floor2 = new Floor(4, "Restaurant");
        floor3 = new Floor(5, "Saloon");
        floor4 = new Floor(6, "Taras");

        room1 = new Room(10, "Bathroom", 25, 85, 25, 40);
        room2 = new Room(11, "Toilet", 15, 10, 10, 10);
        room3 = new Room(12, "Kitchen", 40, 160, 45, 150);
        room4 = new Room(13, "Bedroom", 20, 55, 30, 30);
        room5 = new Room(14, "Living room", 125, 130, 215, 115);
        room6 = new Room(15, "Painting room", 40, 120, 35, 50);

        room7 = new Room(10, "Bathroom", 25, 85, 25, 40);
        room8 = new Room(11, "Living room", 15, 50, 10, 10);
        room9 = new Room(12, "Kitchen", 40, 160, 45, 150);
        room10 = new Room(13, "Bedroom", 20, 55, 30, 30);

        floor1.add(room1);
        floor1.add(room2);
        floor1.add(room3);
        floor1.add(room4);
        floor1.add(room5);
        floor1.add(room6);

        floor2.add(room7);
        floor2.add(room8);
        floor2.add(room9);
        floor2.add(room10);

        floor3.add(room2);
        // floor4 has no rooms

        building1.add(floor1);
        building1.add(floor2);

        building2.add(floor3);
        building2.add(floor4);  //add empty floor

        building3.add(floor3);

        building1Floors = new ArrayList<Floor>();
        building1Floors.add(floor1);
        building1Floors.add(floor2);

        building2Floors = new ArrayList<Floor>();
        building2Floors.add(floor3);
        building2Floors.add(floor4);

        building3Floors = new ArrayList<Floor>();
        building3Floors.add(floor3);


    }

    /**
     * Pass when list is created correctly.
     */
    @Test
    void testGetFloors() {
        Assert.assertEquals(building1Floors, building1.getFloors());
        Assert.assertEquals(building2Floors, building2.getFloors());
        Assert.assertEquals(building3Floors, building3.getFloors());
    }

    /**
     * Check sum of all floors
     * first test: add 2 floors, first has 1 room, second don't have any
     * second test: add single floor
     */
    @Test
    void testGetArea() {
        assertEquals(365, building1.getArea()); //sum couple of rooms
        assertEquals(15, building2.getArea()); //sum two floors, floor4 is empty
        assertEquals(15, building3.getArea()); //sum single floor
    }

    /**
     * Check light getter.
     */
    @Test
    void testGetLight() {
        assertEquals(625, building1.getLight()); //sum couple of rooms
        assertEquals(10, building2.getLight()); //sum two floors, floor4 is empty
        assertEquals(10, building3.getLight()); //sum single floor
    }

    /**
     * Check cubature getter.
     */
    @Test
    void testGetCube() {
        assertEquals(910, building1.getCube()); //sum couple of rooms
        assertEquals(10, building2.getCube()); //sum two floors, floor4 is empty
        assertEquals(10, building3.getCube()); //sum single floor
    }

    /**
     * Check heating getter.
     */
    @Test
    void testGetHeating() {
        assertEquals(470, building1.getHeating()); //sum couple of rooms
        assertEquals(10, building2.getHeating()); //sum two floors, floor4 is empty
        assertEquals(10, building3.getHeating()); //sum single floor
    }

    /**
     * TODO cała ta funkcja, rozkminić jak wyjąć wszystkie pokoje
     */
    @Test
    void testLevelHeating() {
        assertEquals(1, building1.levelHeating(0.6f)); //sum couple of rooms
        //assertEquals(10, building2.levelHeating(1)); //sum two floors, floor4 is empty
        //assertEquals(10, building3.levelHeating(1)); //sum single floor
    }


}