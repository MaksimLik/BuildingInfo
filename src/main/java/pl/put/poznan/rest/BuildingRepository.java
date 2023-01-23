package pl.put.poznan.rest;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.put.poznan.logic.Building;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {


}
