package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * Contains info about building.
 */
public class Building extends Location
{


    /**
     * Array List with information about all our floors in Building
     */
    ArrayList<Floor> floors = new ArrayList<Floor>();
    /**
    * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * @see Location#Location(int id, String name)
    */
    public Building(int id, String name)
    {
        super(id, name);

    }
    /**
     * This method returns our floors to us
     * @return all our floors in building
     */
    public ArrayList<Floor> getFloors()
    {
        return floors;
    }

    /**
     * This method add objects as floor
     * @param object floor
     */
    public void add(Floor object)
    {
        floors.add(object);
    }
    /**
     * This method uses for show information about all floors
     * Their id and name as table
     */
    public void show()
    {
        System.out.println("List of floors in building " + this.name + ": ");
        floors.forEach((n) -> System.out.println("|- " + n.name));
        for (Floor floor : floors)
        {
            System.out.println("|- " + floor.id + ". " + floor.name);
            ArrayList<Room> rooms = floor.getRooms();
            for (Room r : rooms)
                System.out.println("  |- " + r.id + ". " +  r.name);
        }
    }
    /**
     * This method uses to calculate the all area in building
     * @return sum of area all floors in building as [m^2]
     */
    public float sumArea()
    {
        float sum = 0;
        for (Floor floor : floors)
        {
            sum = sum + floor.sumArea();
        }

        return sum;
    }

    /**
     * This method show information about all area in building as [m^2]
     */
    public void showArea()
    {
        System.out.println(this.name + " building area: " + sumArea());
    }

    /**
     * This method to calculate cube sum
     * @return sum as [m^3] of area on all floors in building
     */
    public float sumCube()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.sumCube();
        return sum;
    }
}
