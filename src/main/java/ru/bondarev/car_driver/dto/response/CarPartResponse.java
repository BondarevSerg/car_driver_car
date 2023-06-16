package ru.bondarev.car_driver.dto.response;


import lombok.Data;

@Data
public class CarPartResponse {
    /**
     * id запчасти
     */
    private Long id;

    /**
     * серийный номер
     */
    private String serialNumber;

    /**
     * название запчасти
     */
    private String name;

    /**
     * На каком авто установлено
     */
    private Long carId;
}
