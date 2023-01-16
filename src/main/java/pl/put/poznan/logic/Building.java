package pl.put.poznan.logic;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains info about building.
 */
@Entity
@Table(name = "Buildings")
public class Building extends BaseLocation implements Serializable
{
    /**
     * Set with information about all our floors in Building.
     */
    @OneToMany(targetEntity = Floor.class, cascade = CascadeType.ALL)
    private Set<Floor> floors;

    /**
    * Constructor - creating a new object with certain values
     * @param name - our name for Building or Room, Floor etc.
     * @see BaseLocation#BaseLocation(int id, String name)
    */
    public Building(String name)
    {
        super(name);
        this.floors = new HashSet<>();
    }

    public Building() {
        this.floors = new HashSet<>();
    }

    public Building(int id, String name) {
        super(id, name);
        this.floors = new HashSet<>();
    }

    /**
     * This method add objects as floor
     * @param floor floor
     */
    public void addFloor(Floor floor)
    {
        if (floor.getId() < 0)
            throw new IllegalArgumentException();
        floors.add(floor);
    }

    /**
     * This method uses for show information about all floors
     * Their id and name as table
     */
    @Override
    public void show()
    {
        System.out.println("List of floors in building " + this.name + ": ");
        floors.forEach((n) -> System.out.println("|- " + n.name));
        for (Floor floor : floors)
        {
            System.out.println("|- " + floor.id + ". " + floor.name);
            Set<Room> rooms = floor.getRooms();
            for (Room r : rooms)
                System.out.println("  |- " + r.id + ". " +  r.name);
        }
    }

    /**
     * This method uses to calculate the all area in building
     * @return sum of area all floors in building as [m^2]
     */
    @Override
    public float getArea()
    {
        float sum = 0;
        for (Floor floor : floors)
        {
            sum = sum + floor.getArea();
        }

        return sum;
    }

    /**
     * Calculate light on the whole building
     * @return sum of area all room in building as [m^2]
     */
    @Override
    public float getLight() {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.getLight();
        return sum;
    }

    /**
     * Show average value power of lightning on the floor.
     * @return light power in lumens
     */
    @Override
    public float getLightPower()
    {
        float sum_area = this.getArea();
        float sum_light = this.getLight();
        return sum_area != 0 ? sum_light / sum_area : 0.0f;
    }

    /**
     * This method calculate sum of cube.
     * @return cube sum as [m^3] in the single building
     */
    @Override
    public float getCube()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.getCube();
        return sum;
    }

    /**
     * Sum heating in the building.
     * @return sum of the heating in whole building
     */
    @Override
    public float getHeating()
    {
        float sum = 0;
        for (Floor floor : floors)
            sum = sum + floor.getHeating();
        return sum;
    }

    /**
     * Add all overheating rooms to one list.
     * @param border border for room's heating
     * @return list of overheated rooms
     */
    public Set<Room> levelHeating(float border)
    {
        Set<Room> rooms_list = new HashSet<Room>();
        for (Floor floor : floors)
        {
            rooms_list.addAll(floor.levelHeating(border));
        }
        return rooms_list;
    }

    /**
     * Get all the floors.
     * @return set of floors
     */
    public Set<Floor> getFloors() {
        return this.floors;
    }
}
