package lk.bula.chameen.spring.repo;

import lk.bula.chameen.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, String> {
    Car getCarByBrandAndModel(String brand, String model);

    boolean existsByBrandAndModel(String brand, String model);
}
