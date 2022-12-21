package pl.put.poznan.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains info about room with all details.
 */

public class Room extends BaseLocation
{
    /** area of room */
    private float area = 0.0F;
    /** cube area of room */
    private float cube = 0.0F;
    /** heating of room */
    private float heating = 0.0F;
    /** light of room */
    private float light = 0.0F;

    /**
     * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * @see BaseLocation#BaseLocation(int id, String name)
     */
    public Room(int id, String name)
    {
        super(id, name);
    }

    /**
     * Additional construction for room
     * @param id - unique number
     * @param name - name for Building or Room, Floor etc.
     * @param area - area of room
     * @param cube - cube area of room [m^3]
     * @param heating - heating of room
     * @param light - light of room
     */
    public Room(int id, String name, float area, float cube, float heating, float light)
    {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }


    /**
     * Shows info about whole room
     */
    @Override
    public void show() {
        System.out.println("Info about this room: "+ this.name);
        System.out.println("Id: " + this.id);
        System.out.println("Area: " + this.area);
        System.out.println("Cube: " + this.cube);
        System.out.println("Heating: " + this.heating);
        System.out.println("Light: " + this.light);
    }

    /**
     * Show power of the light measured in lumens
     */
    @Override
    public void showLightPower()
    {
        System.out.print("Power of lightning in room " + this.name +": ");
        if (this.area !=0)
            System.out.println(this.light / this.area);
        else
            System.out.println("0");
    }

    @Override
    public float getArea() {
        return area;
    }

    /**
     * Method feeding the size of one room
     * @return size as [m^3]
     */
    @Override
    public float getCube() {
        return cube;
    }

    /**
     * Method feeding the heating of one room
     * @return amount of energy
     */
    @Override
    public float getHeating() {
        return heating;
    }

    /**
     * Method feeding the light of one room
     * @return amount of energy
     */
    @Override
    public float getLight() {
        return light;
    }


    public boolean heatingLevel(float border)
    {
        if( (this.cube != 0) && (this.heating / this.cube > border) )
        {
            return true;
        }
        return false;
    }
}


