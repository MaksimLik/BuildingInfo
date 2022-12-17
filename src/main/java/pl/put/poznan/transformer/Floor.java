package pl.put.poznan.transformer;

import java.util.ArrayList;
import java.util.Arrays;

public class Floor extends Room
{
    private ArrayList<Room> rooms = new ArrayList<Room>();
    public Floor(int id, String name)
    {
        super(id, name);
    }

    public ArrayList<Room> getRooms(){
        return rooms;
    }

    public void add(Room object)
    {
        rooms.add(object);
    }

    public void show()
    {
        System.out.println("List of rooms on floor " + this.name + ": ");
        rooms.forEach((n) -> System.out.println(n.name));
    }

    public float sumArea()
    {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.area;
        return sum;
    }

    public float sumCube()
    {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.cube;
        return sum;
    }
}