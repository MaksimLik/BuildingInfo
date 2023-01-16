package pl.put.poznan.logic;

import org.apache.tomcat.util.digester.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Building class test.
 */
class BuildingTest {
    /** building1: normal
     *  building2: with fake room
     *  building3: with fake floor
     */
    Building building1, building2, building3;
    /** floor1: 3 rooms
     *  floor2: fake room
     *  floor3: fake floor
     */
    Floor floor1, floor2, floor3;
    /** room1-3: normal
     *  room4: fake
     */
    Room room1, room2, room3, room4;

    @BeforeEach
    public void setUp() throws Exception  {
        building1 = new Building(1,"Zamek");
        building2 = new Building(2,"Willa");
        building3 = new Building(3,"Schowek");

        floor1 = new Floor(3, "Carpet");
        floor2 = new Floor(4, "Restaurant");
        floor3 = new Floor(-1, "Fake floor");

        room1 = new Room(10, "Bedroom", 25, 85, 25, 40);
        room2 = new Room(11, "Toilet", 15, 10, 10, 10);
        room3 = new Room(12, "Kitchen", 40, 160, 45, 150);
        room4 = new Room(13, "Fake room", 1, -1, 1, -1);

        floor1.addRoom(room1);
        floor1.addRoom(room2);
        floor1.addRoom(room3);
        try {
            floor2.addRoom(room4); //fake room
        } catch (IllegalArgumentException ignored){}
        floor3.addRoom(room1); //fake floor

        building1.addFloor(floor1);
        building2.addFloor(floor2);
        try {
            building3.addFloor(floor3);
        } catch (IllegalArgumentException ignored){}
    }

    /**
     * Test throwing exception when add invalid floor.
     */
    @Test
    void testAddFloor()
    {
        assertThrows(IllegalArgumentException.class,
                () -> building3.addFloor(floor3));
    }
    /**
     * Pass when list is created correctly.
     * building1 should return normal floors with rooms.
     * building2 should have only floor without room.
     * building3 shouldn't have floors, so there is no need to add any.
     */
    @Test
    void testGetFloors() {
        Set<Floor> buildingFloors1 = new HashSet<Floor>();
        Set<Floor> buildingFloors2 = new HashSet<Floor>();
        Set<Floor> buildingFloors3 = new HashSet<Floor>();
        buildingFloors1.add(floor1);
        buildingFloors2.add(floor2);

        Assert.assertEquals(buildingFloors1, building1.getFloors());
        Assert.assertEquals(buildingFloors2, building2.getFloors());
        Assert.assertEquals(buildingFloors3, building3.getFloors());
    }

    /**
     * Check sum of all floors
     * First test: sum single floor
     * Second test: sum 1 floor with 1 fake room
     * Third: fake floor
     */
    @Test
    void testGetArea() {
        assertEquals(80, building1.getArea());
        assertEquals(0, building2.getArea());
        assertEquals(0, building3.getArea());
    }

    /**
     * Check light getter
     * First test: sum single floor
     * Second test: 1 floor with 1 fake room
     * Third: fake floor
     */
    @Test
    void testGetLight() {
        assertEquals(200, building1.getLight());
        assertEquals(0, building2.getLight());
        assertEquals(0, building3.getLight());
    }

    /**
     * Check cubature getter.
     * First test: sum single floor.
     * Second test: 1 floor with 1 fake room.
     * Third: fake floor.
     */
    @Test
    void testGetCube() {
        assertEquals(255, building1.getCube());
        assertEquals(0, building2.getCube());
        assertEquals(0, building3.getCube());
    }

    /**
     * Check heating getter.
     * First test: sum single floor.
     * Second test: 1 floor with 1 fake room.
     * Third: fake floor.
     */
    @Test
    void testGetHeating() {
        assertEquals(80, building1.getHeating());
        assertEquals(0, building2.getHeating());
        assertEquals(0, building3.getHeating());
    }

    /**
     * Check level heating getter.
     * building1 contains only 1 room overheated.
     */
    @Test
    void testLevelHeating() {
        Set<Room> chosenRooms = new HashSet<Room>();
        chosenRooms.add(room2);     // overheated with border 0.6
        Assert.assertEquals(chosenRooms, building1.levelHeating(0.6f));
    }
}
