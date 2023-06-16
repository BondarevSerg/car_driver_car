package ru.bondarev.car_driver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Car {

    /**
     * id авто
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * марка авто
     */
    @Column(name = "brand")
    private String brand;

    /**
     * номер авто
     */
    @Column(name = "number")
    private String number;

    /**
     * водитель
     */
    @ManyToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Driver driver;

    /**
     * Список запчастей
     */
    @OneToMany(mappedBy = "car")
    private List<CarPart> carParts;

}
