package pl.put.poznan.logic;

import java.util.ArrayList;

/**
 * Contains info about building
 */
public class Building extends BaseLocation
{
    /**
     * Array List with information about all our floors in Building
     */
    ArrayList<Floor> floors = new ArrayList<Floor>();
    /**
    * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * @see BaseLocation#BaseLocation(int id, String name)
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
    @Override
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
    @Override
    public float getArea()
    {
        float sum = 0;
        for (Floor floor : floors)
        {
            sum = sum + floor.getArea();
        }

        return sum;
    }
    /**
     * Calculate light on the whole building
     * @return sum of area all room in building as [m^2]
     */
    @Override
    public float getLight() {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.getLight();
        return sum;
    }

    /**
     * Show average value power of lightning on the floor
     */
    public void showLightPower()
    {
        float sum_area = this.getArea();
        float sum_light = this.getLight();
        System.out.print("Average power of lightning in whole building " + this.name +": ");
        if (sum_area != 0)
            System.out.println(sum_light / sum_area);
        else
            System.out.println("0");
    }

    /**
     * This method calculate cube
     * @return sum as [m^3] of area on all floors in building
     */
    @Override
    public float getCube()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.getCube();
        return sum;
    }

    /**
<<<<<<< Updated upstream
     * Method get value of heating in Building
=======
     * Sum heating in the building
>>>>>>> Stashed changes
     * @return sum of the heating in whole building
     */
    @Override
    public float getHeating()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.getHeating();
        return sum;
    }

    /**
<<<<<<< Updated upstream
     * This method create list of room with information about heating in building
     * @param border this is border of building
     * @return list of rooms with information about heating
=======
     * Add all overheating rooms to one list
     * @param border border for room's heating
     * @return list of overheated rooms
>>>>>>> Stashed changes
     */
    public ArrayList<Room> levelHeating(float border)
    {
        ArrayList<Room> rooms_list = new ArrayList<Room>();
        for (Floor floor : floors)
        {
            rooms_list.addAll(floor.levelHeating(border));
        }
        return rooms_list;
    }
}
