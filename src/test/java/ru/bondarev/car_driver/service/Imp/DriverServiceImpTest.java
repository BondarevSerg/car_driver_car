package ru.bondarev.car_driver.service.Imp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.bondarev.car_driver.dto.response.DriverResponse;
import ru.bondarev.car_driver.entity.Car;
import ru.bondarev.car_driver.entity.Driver;
import ru.bondarev.car_driver.repository.DriverRepository;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;



@ExtendWith(MockitoExtension.class)
class DriverServiceImpTest {


     @Mock
    private  DriverRepository driverRepository;

    @InjectMocks
    private DriverServiceImp driverService;

    private Driver testDriver;


    @BeforeEach
    void init() {


        ArrayList<Car>cars = new ArrayList<>();

        cars.add(Car.builder()
                .id(1L)
                .brand("testCar")
                .build());

        testDriver = Driver.builder()
                .id(1L)
                .name("testDriver")
                .birthday(LocalDate.of(1991,02,11))
                .greenmoney(100.0)
                .cars(cars)
                .build();
    }


    @Test
    void getDriverById() {

        when(driverRepository.findById(anyLong())).thenReturn(Optional.of(testDriver));
        DriverResponse existingDriverResponse = driverService.getDriverById(testDriver.getId());
        assertNotNull(existingDriverResponse);
        assertThat(existingDriverResponse.getId()).isNotEqualTo(null);
    }

    @Test
    void getNameBirthtdayDrivers() {
    }

    @Test
    void getAllDriver() {
    }

    @Test
    void saveDriver() {
    }

    @Test
    void deleteDriver() {
    }

    @Test
    void updateDriver() {
    }
}