package pl.put.poznan.logic;

import java.util.ArrayList;
/**
 * Contains info about floor.
 */

public class Floor extends Location
{
    /**
     * Array List with information about all our rooms in floor
     */
    private ArrayList<Room> rooms = new ArrayList<Room>();
    /**
     * Constructor - creating a new object with certain values
     * @see Floor#Floor(int id, String name)
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     */
    public Floor(int id, String name)
    {
        super(id, name);
    }
    /**
     * This method returns our Rooms
     * @return all our rooms of one floor
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    /**
     * This method add objects as room
     * @param object room
     */
    public void add(Room object)
    {
        rooms.add(object);
    }
    /**
     * This method uses for show information about all rooms in floor
     * Their name as table
     */
    public void show()
    {
        System.out.println("List of rooms on the floor " + this.name + ": ");
        rooms.forEach((n) -> System.out.println(" - " + n.name));
    }
    /**
     * This method uses to calculate the all area in all rooms
     * @return sum of area all room in building as [m^2]
     */
    public float sumArea() {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getArea();

        return sum;
    }
    /**
     * This method is used to display information about the area of one floor
     * Their name as table
     */
    public void showArea()
    {
        System.out.println(this.name + " floor area: " + sumArea());
    }

    /**
     * This method sum information about area rooms
     * @return sum as [m^3] all rooms of one floor
     */
    public float sumCube()
    {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getCube();
        return sum;
    }

}
