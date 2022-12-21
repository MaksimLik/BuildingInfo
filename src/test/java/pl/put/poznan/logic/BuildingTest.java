package pl.put.poznan.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuildingTest {

    private Building building = null;
    @BeforeEach
    public void setUp() throws Exception  {
        building = new Building(1,"Rezydencja");
    }

    @Test
    void sumArea() {
    }

    @Test
    void sumCube() {
    }
}