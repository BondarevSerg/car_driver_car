package ru.bondarev.car_driver.dto.request;


import lombok.Data;
@Data
public class CarPartRequest {


    /**
     * серийный номер
     */
    private String serialNumber;

    /**
     * тип запчасти
     */
    private String name;

    /**
     * На какое авто установить
     */
    private Long carId;
}
