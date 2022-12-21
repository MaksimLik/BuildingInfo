package pl.put.poznan.logic;

import java.util.ArrayList;

public interface Location
{
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
<<<<<<< Updated upstream
     * This method will show information about energy power for lightning of location
=======
     * Method that show average of the light
>>>>>>> Stashed changes
     */
     void showLightPower();

    /**
     * Shows info about locations
     */
     void show();
}
