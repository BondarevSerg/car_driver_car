package ru.bondarev.car_driver.dto.request;


import lombok.Data;


@Data
public class CarRequest {

    /**
     * марка авто
     */
    private String brand;

    /**
     * номер авто
     */
    private String number;

    /**
     * водитель авто
     */

    private Long driverId;



}
