package ru.bondarev.car_driver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
@Entity
@Table(name = "carpart")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class CarPart {

    /**
     * id запчасти
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * серийный номер
     */
    @Column(name = "serialnumber")
    private String serialNumber;

    /**
     * тип запчасти
     */
    @Column(name = "name")
    private String name;

    /**
     * Авто
     */
    @ManyToOne
    @JoinColumn(name = "carid", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;
}
