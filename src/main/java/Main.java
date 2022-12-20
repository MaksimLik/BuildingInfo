import pl.put.poznan.transformer.logic.Building;
import pl.put.poznan.transformer.logic.Floor;
import pl.put.poznan.transformer.logic.Room;

/**
 * Main class for add different objects in application and use function
 */
public class Main
{
    private static Building building = new Building(1,"Willa");
    private static Floor floor = new Floor(1,"Carpet");
    private static Floor floor2 = new Floor(2,"Restaurant");
    private static Room  room  = new Room(123, "Bathroom", 5, 3, 25, 15);
    private static Room  room2  = new Room(521, "Living room", 125, 130, 215, 115);
    private static Room  room3  = new Room(478, "Kitchen", 25, 30, 25, 15);
    private static Room  room4  = new Room(53, "Bedroom", 40, 15, 25, 15);

    /**
     * This is main function for add information about buildings, rooms, floors
     * @param args this is our functions and objects in different classes
     */
    public static void main(String[] args) {
        floor.add(room);
        floor.add(room2);
        floor2.add(room4);
        floor2.add(room3);
        building.add(floor);
        building.add(floor2);
        building.show();
        floor.show();
        floor.showArea();
        building.showArea();
        room2.showArea();
    }
}
