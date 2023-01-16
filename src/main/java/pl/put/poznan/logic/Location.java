package pl.put.poznan.logic;

import java.util.ArrayList;

/**
 * Basic interface which contains universal info about location
 */
public interface Location
{
    /**
     * This method return argument for identification object
     * @return id unique value which positive int number
     */
     int getId();

    /**
     * This method return name of object
     * @return name of object
     */
     String getName();

    /**
     * Method get area of room, floor, building
     * @return size as [m^2]
     */
     float getArea();

    /**
     * Method get cubature of room, floor, building
     * @return size as [m^3]
     */
     float getCube();

    /**
     * Method get heating of room, floor, building
     * @return amount of energy
     */
     float getHeating();

    /**
     * Method get light of room, floor, building
     * @return lightning
     */
     float getLight();

    /**
     * Method that show average of the light
     */
     float getLightPower();

    /**
     * Shows info about locations
     */
     void show();
}
