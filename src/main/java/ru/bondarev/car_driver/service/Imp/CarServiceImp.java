package ru.bondarev.car_driver.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.car_driver.dto.request.CarRequest;
import ru.bondarev.car_driver.dto.response.CarResponse;
import ru.bondarev.car_driver.entity.Driver;
import ru.bondarev.car_driver.mapper.CarMapper;
import ru.bondarev.car_driver.repository.CarRepository;
import ru.bondarev.car_driver.service.CarService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarServiceImp implements CarService {

    private final CarRepository carRepository;

    @Override
    public CarResponse getCarById(Long id) {
        var car = carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("не найден авто по id"));
        return CarMapper.INSTANCE.toDTO(car);
    }

    @Override
    public List<CarResponse> getAllCar() {

        return carRepository.findAll().stream()
                .map(CarMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCar(CarRequest carRequest) {
         carRepository.save(CarMapper.INSTANCE.toEntity(carRequest));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void updateCar(Long id, CarRequest carRequest) {
        var car = carRepository.findById(id)
                .orElseThrow(()->new RuntimeException("не найден авто по id"));
        car.setBrand(carRequest.getBrand());
        car.setNumber(carRequest.getNumber());
        car.setDriver(Driver.builder()
                .id(carRequest.getDriverId()).build());
        carRepository.save(car);
    }
}
