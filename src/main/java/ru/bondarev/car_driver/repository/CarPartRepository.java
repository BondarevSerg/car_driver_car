package ru.bondarev.car_driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.car_driver.entity.CarPart;

public interface CarPartRepository extends JpaRepository<CarPart, Long> {
}
