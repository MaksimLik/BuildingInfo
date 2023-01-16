package pl.put.poznan.logic;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Our abstract class containing information for all objects
 */

@Entity
@Table(name = "locations")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public abstract class BaseLocation implements Location, Serializable {
    /** Our unique element for identification our other objects  */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "location_id")
    protected int id;
    /** Our name information */
    @Column (name = "name")
    protected String name;

    public BaseLocation() {
    }

    /**
     * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * */
    public BaseLocation(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public BaseLocation( String name)
    {
        this.name = name;
    }

    /**
     * Return id, used in other functions
     * @return id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Return name, used in other functions
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Return area, used in other functions
     * @return default 0
     */
    @Override
    public float getArea() {
        return 0;
    }

    /**
     * This method sum size of rooms
     * @return size as [m^3]
     */
    @Override
    public float getCube(){
        return 0;
    }

    /**
     * Method feeding the heating of one room
     * @return amount of energy
     */
    @Override
    public float getHeating() {
        return 0;
    }

    /**
     * Method feeding the light of one room
     * @return amount of energy
     */
    @Override
    public float getLight() {
        return 0;
    }

    public void setName(String name) {
        this.name = name;
    }
}
