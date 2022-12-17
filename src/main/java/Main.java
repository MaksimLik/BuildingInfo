import pl.put.poznan.transformer.Building;
import pl.put.poznan.transformer.Floor;
import pl.put.poznan.transformer.Room;

import javax.swing.*;

public class Main
{
    private static Building building = new Building(1,"Tesla");
    private static Floor floor = new Floor(1,"baza");
    private static Room  room  = new Room(123, "lazienka");
    private static Room  room2  = new Room(21, "salon");
    public static void main(String[] args) {
        floor.add(room);
        floor.add(room2);
        building.add(floor);
        building.show();
    }
}
