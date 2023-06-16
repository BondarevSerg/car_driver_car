package ru.bondarev.car_driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.car_driver.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
