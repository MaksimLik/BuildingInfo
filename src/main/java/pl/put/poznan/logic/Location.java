package pl.put.poznan.logic;

import java.util.ArrayList;

public interface Location {


     int getId();
     String getName();

    /**
     * Method feeding the area of one room
     * @return size as [m^2]
     */
     float getArea();

    /**
     * Method feeding the size of one room
     * @return size as [m^3]
     */
     float getCube();

    /**
     * Method feeding the heating of one room
     * @return amount of energy
     */
     float getHeating();

    /**
     * Method feeding the light of one room
     * @return amount of energy
     */
     float getLight();

    /**
     * This method will show information about energy power for lightning of location
     */
     void showLightPower();

    /**
     * No comments will create in future spring
     */
    void show();


}
