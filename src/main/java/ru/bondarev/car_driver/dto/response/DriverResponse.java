package ru.bondarev.car_driver.dto.response;



import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

import java.util.List;


@Data
@Builder
public class DriverResponse {

    /**
     * id водителя
     */
    private Long id;

    /**
     * имя водителя
     */
    private String name;

    /**
     * дата рождения
     */

    private LocalDate birthday ;

    /**
     * Деньги(базовая валюта будет зеленая. Красная коэффициент 0.4, синяя коэффициент 0.6)
     */
    private Double  greenmoney;

    private Double  redmoney;

    private Double bluenmoney;
    /**
     * список id авто
     */
    private List<Long> carsId;


}
