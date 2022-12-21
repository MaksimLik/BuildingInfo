package pl.put.poznan.rest;

import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.Floor;
import pl.put.poznan.logic.Location;
import pl.put.poznan.logic.Room;

import java.util.ArrayList;
import java.util.List;

public class BuildingRepository {
    private final List<Building> buildings;

     public BuildingRepository() {
         buildings = new ArrayList<Building>();
         Building building = new Building(1, "Willa");

         Building building2 = new Building(2, "Zamek");
         Floor floor = new Floor(3, "Carpet");
         Floor floor2 = new Floor(4, "Restaurant");
         Room room = new Room(123, "Bathroom", 5, 3, 25, 15);
         Room room2 = new Room(521, "Living room", 125, 130, 215, 115);
         Room room3 = new Room(478, "Kitchen", 25, 30, 25, 15);
         Room room4 = new Room(53, "Bedroom", 40, 15, 25, 15);
         floor.add(room);
         floor.add(room2);
         floor2.add(room4);
         floor2.add(room3);
         building.add(floor);
         building.add(floor2);

         buildings.add(building);
         buildings.add(building2);
     }
     public List<Building> getBuildings() {
         return buildings;
     }

     public void insertBuilding(Building building) {
         buildings.add(building);
     }

    public void deleteLocationById(int id) {
         buildings.forEach(building -> {
             if (building.getId() == id) buildings.remove(building);

             building.getFloors().forEach(floor -> {
                 if (floor.getId() == id) building.getFloors().remove(floor);

               floor.getRooms().forEach(room -> {
                   if (room.getId() == id) floor.getRooms().remove(room);
               });

             });

         });
    }

    public Location getLocationById(int id) {
        Location l = null;
        for (int i = 0; i < buildings.size(); i++) {
            Building b = buildings.get(i);
            if (b.getId() == id){ l = b; break;}

            for (int j = 0; j < b.getFloors().size(); j++) {
                Floor f = b.getFloors().get(j);
                if (f.getId() == id){ l = f; break;}

                for (int k = 0; k < f.getRooms().size(); k++) {
                    Room r = f.getRooms().get(k);
                    if (r.getId() == id) {l = r; break;}
                }

            }
        }
        return l;
    }
}
