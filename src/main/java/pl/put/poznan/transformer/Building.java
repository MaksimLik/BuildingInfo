package pl.put.poznan.transformer;

import java.util.ArrayList;

/**
 * Contains info about building.
 */
public class Building extends Floor
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
        floors.forEach((n) -> System.out.println(n.name));
    }

    public float sumArea()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.area;
        return sum;
    }

    public float sumCube()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.cube;
        return sum;
    }
}
