package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * Our abstract class containing information for all objects
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class Location
{
    /** Our unique element for identification our other objects  */
    protected int id;
    /** Our name information */
    protected String name;
    /**
     * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * */
    public Location(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
