package ru.bondarev.car_driver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.car_driver.dto.request.CarRequest;
import ru.bondarev.car_driver.dto.response.CarResponse;
import ru.bondarev.car_driver.service.Imp.CarServiceImp;


import java.util.List;

/**
 * контроллер автомобилей
 */
@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Tag(
        name = "Авто",
        description = "Все операции с авто"
)
public class CarController {

    private  final CarServiceImp carService;
    /**
     * Получение  авто по id
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение  авто по id")
    public CarResponse getCarById(@Parameter(description = "id авто")
                                        @PathVariable("id")Long id) {
        return carService.getCarById(id);
    }

    /**
     * Получение всех авто
     *
     * @return
     */
    @GetMapping()
    @Operation(summary = " Получение всех авто")
    public List<CarResponse> getAllCar() {
        return carService.getAllCar();
    }

    /**
     * сохранение нового авто
     * @param carRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение нового авто")
    public ResponseEntity<HttpStatus> create(@RequestBody CarRequest carRequest) {

        carService.saveCar(carRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * удаление авто
     * @param id
     * @return
     */
    @DeleteMapping ("/{id}")
    @Operation(summary = "удаление авто")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id авто")
                                             @PathVariable("id")Long id) {

        carService.deleteCar(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    /**
     * обновление  авто
     *
     * @param id
     * @param carRequest
     * @return
     */
    @PutMapping("/{id}")
    @Operation(summary = "обновление  авто")
    public ResponseEntity<HttpStatus> updateCar(@Parameter(description = "id  авто") @PathVariable("id") Long id,
                                                   @RequestBody CarRequest carRequest) {
        carService.updateCar(id, carRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
