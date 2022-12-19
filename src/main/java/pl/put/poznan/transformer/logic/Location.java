package pl.put.poznan.transformer.logic;

/**
 * Contains basic info about buildings, floors and rooms.
 */
public abstract class Location
{
    protected int id;
    protected String name;
    public Location(int id, String name)
    {
        this.id = id;
        this.name = name;
    }



}
