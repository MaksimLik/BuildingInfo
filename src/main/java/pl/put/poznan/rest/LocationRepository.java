package pl.put.poznan.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.put.poznan.logic.BaseLocation;

public interface LocationRepository extends JpaRepository<BaseLocation, Integer> {
}
