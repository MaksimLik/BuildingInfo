package pl.put.poznan.logic;

/**
 * Contains info about room with all details.
 */

public class Room extends Location
{
<<<<<<< Updated upstream:src/main/java/pl/put/poznan/logic/Room.java
    /** area of room */
    private float area;
    /** cube area of room */
    private float cube;
    /** heating of room */
    private float heating;
    /** light of room */
    private float light;
=======
    private float area = 0.0F;
    private float cube = 0.0F;
    private float heating = 0.0F;
    private float light = 0.0F;
>>>>>>> Stashed changes:src/main/java/pl/put/poznan/transformer/logic/Room.java

    /**
     * Constructor - creating a new object with certain values
     * @param id - our unique number
     * @param name - our name for Building or Room, Floor etc.
     * @see Location#Location(int id, String name)
     */
    public Room(int id, String name)
    {
        super(id, name);
    }

    /**
     * Additional construction for room
     * @param id - unique number
     * @param name - name for Building or Room, Floor etc.
     * @param area - area of room
     * @param cube - cube area of room [m^3]
     * @param heating - heating of room
     * @param light - light of room
     */
    public Room(int id, String name, float area, float cube, float heating, float light)
    {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

<<<<<<< Updated upstream:src/main/java/pl/put/poznan/logic/Room.java
    /**
     * Method feeding the size of one room
     * @return size as [m^2]
     */
=======
    public void showArea()
    {
        System.out.println(this.name + " area: " + this.area);
    }

    public void showLightPower()
    {
        System.out.print("Power of lightning in room " + this.name +": ");
        if (this.area !=0)
            System.out.println(this.light / this.area);
        else
            System.out.println("0");
    }


>>>>>>> Stashed changes:src/main/java/pl/put/poznan/transformer/logic/Room.java
    public float getArea() {
        return area;
    }

    /**
     * Method feeding the size of one room
     * @return size as [m^3]
     */
    public float getCube() {
        return cube;
    }

    /**
     * Method feeding the heating of one room
     * @return amount of energy
     */
    public float getHeating() {
        return heating;
    }

    /**
     * Method feeding the light of one room
     * @return amount of energy
     */
    public float getLight() {
        return light;
    }
    /**
     * This method uses for show information about one room
     * Their area as table
     */
    public void showArea()
    {
        System.out.println(this.name + " area: " + this.area);
    }

}
