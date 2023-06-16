package ru.bondarev.car_driver.service;

import ru.bondarev.car_driver.dto.request.DriverRequest;
import ru.bondarev.car_driver.dto.response.DriverResponse;

import java.util.List;

public interface DriverService {

    /**
     * Получение водителя по идентификатору
     *
     * @param id идентификатор
     * @return
     */
    DriverResponse getDriverById(Long id);

    /**
     * Получения имен  водителей у которых сегодня день рождения
     *
     */
    List<String>  getNameBirthtdayDrivers();

    /**
     * Получения всех водителей
     *
     */
    List<DriverResponse> getAllDriver();

    /**
     * сохранение нового водителя
     *
     * @param driverRequest
     */
    void saveDriver(DriverRequest driverRequest);

    /**
     * удаление  водителя по Id
     *
     * @param id
     */
    void deleteDriver(Long id);

    /**
     * обновление данных водителя
     * @param id
     * @param driverRequest
     */
    void updateDriver(Long id, DriverRequest driverRequest);
}
