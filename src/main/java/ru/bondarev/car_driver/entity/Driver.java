package ru.bondarev.car_driver.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "driver")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Driver {

    /**
     * id водителя
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * имя водителя
     */
    @Column(name = "name")
    private String name;

    /**
     * дата рождения
     */
    @Column(name = "birthday")
    private LocalDate birthday ;

    /**
     * Деньги(базовая валюта будет зеленая. Красная коэффициент 0.4, синяя коэффициент 0.6)
     */
    @Column(name = "money")
    private Double  greenmoney;

    /**
     * список авто(за водителем могут быть закреплены несколько авто)
     */
    @OneToMany(mappedBy = "driver")
    private List<Car> cars;

}
