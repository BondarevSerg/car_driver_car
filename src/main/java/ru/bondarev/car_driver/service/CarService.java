package ru.bondarev.car_driver.service;

import ru.bondarev.car_driver.dto.request.CarRequest;
import ru.bondarev.car_driver.dto.request.DriverRequest;
import ru.bondarev.car_driver.dto.response.CarResponse;
import ru.bondarev.car_driver.dto.response.DriverResponse;

import java.util.List;

public interface CarService {
    /**
     * Получение авто по идентификатору
     *
     * @param id идентификатор
     * @return
     */
    CarResponse getCarById(Long id);

    /**
     * Получения всех авто
     *
     */
    List<CarResponse> getAllCar();

    /**
     * сохранение нового авто
     *
     * @param carRequest
     */
    void saveCar(CarRequest carRequest);

    /**
     * удаление  авто по id
     *
     * @param id
     */
    void deleteCar(Long id);

    /**
     * обновление авто
     * @param id
     * @param carRequest
     */
    void updateCar(Long id, CarRequest carRequest);
}
