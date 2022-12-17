package pl.put.poznan.transformer;

/**
 * Contains basic info about buildings, floors and rooms.
 */
public class Location
{
    public int id;
    public String name;
    public Location(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }
}
