package pl.put.poznan.transformer.logic;

import java.util.ArrayList;

/**
 * Contains info about building.
 */
public class Building extends Location
{
    ArrayList<Floor> floors = new ArrayList<Floor>();

    public Building(int id, String name)
    {
        super(id, name);

    }

    public ArrayList<Floor> getFloors()
    {
        return floors;
    }

    public void add(Floor object)
    {
        floors.add(object);
    }

    public void show()
    {
        System.out.println("List of floors in building " + this.name + ": ");
        //floors.forEach((n) -> System.out.println("|- " + n.name));
        for (Floor floor : floors)
        {
            System.out.println("|- " + floor.id + ". " + floor.name);
            ArrayList<Room> rooms = floor.getRooms();
            for (Room r : rooms)
                System.out.println("  |- " + r.id + ". " +  r.name);
        }
    }

    public float sumArea()
    {
        float sum = 0;
        for (Floor floor : floors)
        {
            sum = sum + floor.sumArea();
        }

        return sum;
    }

    public void showArea()
    {
        System.out.println(this.name + " building area: " + sumArea());
    }

    public float sumCube()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.sumCube();
        return sum;
    }
}
