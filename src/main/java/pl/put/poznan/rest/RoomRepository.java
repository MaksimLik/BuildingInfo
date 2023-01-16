package pl.put.poznan.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.put.poznan.logic.Building;
import pl.put.poznan.logic.BaseLocation;
import pl.put.poznan.logic.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}