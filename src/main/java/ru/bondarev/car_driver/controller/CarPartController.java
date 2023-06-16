package ru.bondarev.car_driver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.car_driver.dto.request.CarPartRequest;
import ru.bondarev.car_driver.dto.response.CarPartResponse;
import ru.bondarev.car_driver.service.Imp.CarPartServiceImp;


import java.util.List;

/**
 * контроллер запчасти
 */
@RestController
@RequestMapping("/carparts")
@RequiredArgsConstructor
@Tag(
        name = "Запчасти",
        description = "Все операции с запчастями"
)
public class CarPartController {

    private  final CarPartServiceImp carPartService;
    /**
     * Получение  запчасти по id
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение  запчасти по id")
    public CarPartResponse getCarById(@Parameter(description = "id запчасти")
                                  @PathVariable("id")Long id) {
        return carPartService.getCarPartById(id);
    }


    /**
     * Получение всех запчастей
     *
     * @return
     */
    @GetMapping()
    @Operation(summary = " Получение всех авто")
    public List<CarPartResponse> getAllCar() {
        return carPartService.getAllCarPart();
    }

    /**
     * сохранение новой запчасти
     * @param carPartRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение новой запчасти")
    public ResponseEntity<HttpStatus> create(@RequestBody CarPartRequest carPartRequest) {

        carPartService.saveCarPart(carPartRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * удаление запчасти
     * @param id
     * @return
     */
    @DeleteMapping ("/{id}")
    @Operation(summary = "удаление запчасти")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id запчасти")
                                             @PathVariable("id")Long id) {

        carPartService.deleteCarPart(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
