package ru.bondarev.car_driver.dto.response;

import lombok.Data;


import java.util.List;

@Data
public class CarResponse {

    /**
     * id авто
     */
    private Long id;
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

    /**
     * Список запчастей
     */
    private List<CarPartResponse> carPartResponses;
}
