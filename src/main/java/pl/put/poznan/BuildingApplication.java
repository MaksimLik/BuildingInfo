package pl.put.poznan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class uses for Spring and REST API application
 * Build API application
 */
@SpringBootApplication
public class BuildingApplication {
    /**
     * This method run application in Spring technology
     * @param args which are used for spring application
     */
     public static void main(String[] args) {
         SpringApplication.run(BuildingApplication.class, args);
    }
}
