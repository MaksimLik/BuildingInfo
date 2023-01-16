package pl.put.poznan.logic;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Contains info about single floor.
 */
@Entity
@Table(name = "Floors")
public class Floor extends BaseLocation implements Serializable
{
    /**
     * Set with information about all our rooms in floor
     */
    @OneToMany(targetEntity = Room.class, cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @JsonIgnore
    @ManyToOne(targetEntity = Building.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="building_id", referencedColumnName = "location_id")
    private Building building;

//
//    /**
//     * Class constructor
//     * @see Floor#Floor(int id, String name)
//     * @param id - our unique number
//     * @param name - our name for Building or Room, Floor etc.
//     */


    public Floor(int id, String name) {
        super(id, name);
        this.rooms = new HashSet<>();

    }

    public Floor(String name) {
        super(name);
        this.rooms = new HashSet<>();
    }

    public Floor() {
        this.rooms = new HashSet<>();
    }



    public void setBuilding(Building building) {
        this.building = building;
    }


    public Set<Room> getRooms() {
        return rooms;
    }

    public Building getBuilding() {
        return building;
    }

    /**
     * This method add Room objects to list of rooms
     * @param room room
     */
    public void addRoom(Room room)
    {
        if ((room.getArea() < 0) || (room.getCube() < 0) || (room.getLight() < 0))
            throw new IllegalArgumentException();
        rooms.add(room);
    }

    /**
     * This method uses for show information about all rooms on the floor
     * Their name as table
     */
    @Override
    public void show()
    {
        System.out.println("List of rooms on the floor " + this.name + ": ");
        rooms.forEach((n) -> System.out.println(" - " + n.name));
    }

    /**
     * This method uses to calculate the all area in all rooms
     * @return sum of area all room in building as [m^2]
     */
    @Override
    public float getArea() {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getArea();
        return sum;
    }

    /**
     * Calculate light on the whole floor
     * @return sum of area all room in building as [m^2]
     */
    @Override
    public float getLight() {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getLight();
        return sum;
    }

    /**
     * Show average value power of lightning on the floor
     */
    @Override
    public float getLightPower()
    {
        float sum_area = this.getArea();
        float sum_light = this.getLight();
        return sum_area != 0 ? sum_light / sum_area : 0.0f;
    }

    /**
     * This method sum cubes
     * @return sum as [m^3] all rooms on the single floor
     */
    @Override
    public float getCube()
    {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getCube();
        return sum;
    }

    /**
     * Get the sum of heating
     * @return summary power of the heating
     */
    @Override
    public float getHeating() {
        float sum = 0;
        for (Room room : rooms)
            sum = sum + room.getHeating();
        return sum;
    }

    /**
     * Select overheated rooms
     * @param border heating value which cannot be overrated
     * @return list of overheated rooms
     */
    public Set<Room> levelHeating(float border)
    {
        Set<Room> group = new HashSet<Room>();
        for (Room room : rooms)
            if (room.heatingLevel(border))
                group.add(room);
        return group;
    }
}
