package ru.bondarev.car_driver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bondarev.car_driver.entity.Driver;

import java.time.LocalDate;
import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findByBirthday(LocalDate date);
}
