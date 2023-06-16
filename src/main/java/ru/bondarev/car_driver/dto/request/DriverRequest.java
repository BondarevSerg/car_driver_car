package ru.bondarev.car_driver.dto.request;


import lombok.Data;


import java.time.LocalDate;

@Data
public class DriverRequest {

    /**
     * имя водителя
     */
    private String name;



    /**
     * Деньги(базовая валюта будет зеленая. Красная коэффициент 0.4, синяя коэффициент 0.6)
     */
    private Double  greenmoney;

    private Double  redmoney;

    private Double bluenmoney;

    /**
     * Авто
     */
    private Long carId;

    /**
     * дата рождения
     */

    private LocalDate birthday;
}
