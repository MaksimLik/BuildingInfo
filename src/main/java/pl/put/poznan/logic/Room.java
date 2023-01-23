package pl.put.poznan.logic;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains info about room with all details.
 */

@Entity
@Table(name="Rooms")
public class Room extends BaseLocation
{
    /** area of room */
    @Column(name = "area")
    private float area;
    /** cube area of room */
    @Column(name = "cubature")
    private float cube;
    /** heating of room */
    @Column(name = "heating")
    private float heating;
    /** light of room */
    @Column(name = "light")
    private float light;

    @JsonIgnore
    @ManyToOne(targetEntity = Floor.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="floor_id", referencedColumnName = "location_id")
    private Floor floor;

    public Room() {

    }

    public Room(String name){
        super(name);
    }

    /**
     * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * @see BaseLocation#BaseLocation(int id, String name)
     */
    public Room(int id, String name)
    {
        super(id, name);
    }

    /**
     * Additional construction for room
     * @param name - name for Building or Room, Floor etc.
     * @param area - area of room
     * @param cube - cube area of room [m^3]
     * @param heating - heating of room
     * @param light - light of room
     */
    public Room(String name, float area, float cube, float heating, float light)
    {
        super( name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    public Room(int id, String name, float area, float cube, float heating, float light)
    {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    /**
     * Shows info about whole room
     */
    @Override
    public void show() {
        System.out.println("Info about this room: "+ this.name);
        System.out.println("Id: " + this.id);
        System.out.println("Area: " + this.area);
        System.out.println("Cube: " + this.cube);
        System.out.println("Heating: " + this.heating);
        System.out.println("Light: " + this.light);
    }

    /**
     * Get power of the light measured in lumens if area is a positive value.
     * @return power of the light measured in lumens
     */
    @Override
    public float getLightPower()
    {
        return this.area > 0 ? this.light / this.area : 0.0f;
    }

    /**
     * Getter for area of this room
     * @return area
     */
    @Override
    public float getArea() {
        return area;
    }

    /**
     * Getter for cubes of this room
     * @return size as [m^3]
     */
    @Override
    public float getCube() {
        return cube;
    }

    /**
     * Getter for heating of this room
     * @return amount of energy
     */
    @Override
    public float getHeating() {
        return heating;
    }

    /**
     * Getter for light of this room
     * @return amount of energy
     */
    @Override
    public float getLight() {
        return light;
    }

    /**
     * Decide if heating in the room is above selected value
     * @param border selected value
     * @return true if overheated, false if not
     */
    public boolean heatingLevel(float border)
    {
        return (this.cube != 0) && (this.heating / this.cube > border);
    }

    /**
     * Use for REST API
     * @param floor floor where is that room
     */
    public void setFloor(Floor floor)
    {
        this.floor = floor;
    }

    /**
     * Update data for room.
     * @param newRoom data of updated room
     */
    public void updateRoom(Room newRoom)
    {
        this.name = newRoom.getName();
        this.area = newRoom.getArea();
        this.cube = newRoom.getCube();
        this.heating = newRoom.getHeating();
        this.light = newRoom.getLight();
    }

    public Floor getFloor() {
        return this.floor;
    }
}


