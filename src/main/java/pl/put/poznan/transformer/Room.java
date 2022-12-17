package pl.put.poznan.transformer;

/**
 * Contains info about room with all details.
 */
public class Room extends Location
{
    protected float area = 0;
    protected float cube = 0;
    protected float heating = 0;
    protected float light = 0;

    public Room(int id, String name)
    {
        super(id, name);
    }

    protected Room(int id, String name, float area, float cube, float heating, float light)
    {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    protected float roomArea()
    {
        return this.area;
    }
}
