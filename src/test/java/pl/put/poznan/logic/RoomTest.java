package pl.put.poznan.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Room class test.
 */
class RoomTest
{
    Room room1, room2, room3;
    @BeforeEach
    void setUp()
    {
        room1 = new Room(1, "Bathroom", 25, 85, 25, 40);
        room2 = new Room(2, "Living room", 40, 160, 105, 250);
        room3 = new Room(3, "Fake room", 1, -1, -1, -1);
    }

    @Test
    void testGetArea()
    {
        Assert.assertEquals(25, room1.getArea());
        Assert.assertEquals(40, room2.getArea());
    }

    /**
     * Get right cubature of the room.
     */
    @Test
    void testGetCube()
    {
        Assert.assertEquals(85, room1.getCube());
        Assert.assertEquals(160, room2.getCube());
    }

    /**
     * Get right heating of the room.
     */
    @Test
    void testGetHeating()
    {
        Assert.assertEquals(25, room1.getHeating());
        Assert.assertEquals(105, room2.getHeating());
    }

    /**
     * Get right light of the room.
     */
    @Test
    void testGetLight()
    {
        Assert.assertEquals(40, room1.getLight());
        Assert.assertEquals(250, room2.getLight());
    }

    /**
     * Get right light power in lumens of the room.
     */
    @Test
    void testGetLightPower()
    {
        Assert.assertEquals(1.6f, room1.getLightPower());
        Assert.assertEquals(6.25f, room2.getLightPower());
    }

    /**
     * Check if heating is exceeded.
     */
    @Test
    void testHeatingLevel()
    {
        Assert.assertEquals(false, room1.heatingLevel(0.6f));
        Assert.assertEquals(true, room2.heatingLevel(0.6f));
    }
}
