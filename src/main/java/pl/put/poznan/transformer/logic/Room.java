package pl.put.poznan.transformer.logic;

import pl.put.poznan.transformer.logic.Location;

/**
 * Contains info about room with all details.
 */
public class Room extends Location
{
    private float area;
    private float cube;
    private float heating;
    private float light;

    public Room(int id, String name)
    {
        super(id, name);
    }

    public Room(int id, String name, float area, float cube, float heating, float light)
    {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public void showArea()
    {
        System.out.println(this.name + " area: " + this.area);
    }





    public float getArea() {
        return area;
    }

    public float getCube() {
        return cube;
    }

    public float getHeating() {
        return heating;
    }

    public float getLight() {
        return light;
    }
}
