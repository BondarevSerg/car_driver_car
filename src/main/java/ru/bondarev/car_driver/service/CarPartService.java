package ru.bondarev.car_driver.service;

import ru.bondarev.car_driver.dto.request.CarPartRequest;
import ru.bondarev.car_driver.dto.response.CarPartResponse;


import java.util.List;

public interface CarPartService {
    /**
     * Получение запчасти по id
     *
     * @param id
     * @return
     */
    CarPartResponse getCarPartById(Long id);

    /**
     * Получения всех запчастей
     *
     */
    List<CarPartResponse> getAllCarPart();

    /**
     * сохранение новой запчасти
     *
     * @param carPartRequest
     */
    void saveCarPart(CarPartRequest carPartRequest);

    /**
     * удаление  запчасти по id
     *
     * @param id
     */
    void deleteCarPart(Long id);


}
