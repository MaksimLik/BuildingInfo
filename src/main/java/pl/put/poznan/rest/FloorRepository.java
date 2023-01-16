package pl.put.poznan.rest;

import pl.put.poznan.logic.Floor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer> {

}