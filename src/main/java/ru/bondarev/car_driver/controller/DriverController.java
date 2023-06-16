package ru.bondarev.car_driver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bondarev.car_driver.dto.request.DriverRequest;
import ru.bondarev.car_driver.dto.response.DriverResponse;
import ru.bondarev.car_driver.service.Imp.DriverServiceImp;

import java.util.List;

/**
 * контроллер водителей
 */
@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
@Tag(
        name = "Водители",
        description = "Все методы для работы с водителями"
)
public class DriverController {

    private  final DriverServiceImp driverService;
    /**
     * Получение  водителя по id
     *
     * @return
     */
    @GetMapping("/{id}")
    @Operation(summary = "Получение  водителя по id")
    public DriverResponse getDriverById(@Parameter(description = "id водителя")
                                            @PathVariable("id")Long id) {
        return driverService.getDriverById(id);
    }

    /**
     * Получение имен водителей у которых день рождения сегодня
     *
     * @return
     */
    @GetMapping("/birthday")
    @Operation(summary = "Получение имен водителей у которых день рождения сегодня")
    public List<String> getNameBirthtdayDrivers() {
        return driverService.getNameBirthtdayDrivers();
    }

    /**
     * Получение всех водителей
     *
     * @return
     */
    @GetMapping()
    @Operation(summary = " Получение всех водителей")
    public List<DriverResponse> getAllDriver() {
        return driverService.getAllDriver();
    }

    /**
     * сохранение нового водителя
     * @param driverRequest
     * @return
     */
    @PostMapping()
    @Operation(summary = "сохранение нового водителя")
    public ResponseEntity<HttpStatus> create(@RequestBody DriverRequest driverRequest) {

        driverService.saveDriver(driverRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * удаление водителя
     * @param id
     * @return
     */
    @DeleteMapping ("/{id}")
    @Operation(summary = "удаление водителя")
    public ResponseEntity<HttpStatus> delete(@Parameter(description = "id водителя")
                                                 @PathVariable("id")Long id) {

        driverService.deleteDriver(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * обновление  водителя(Основной упор на снятие и начисление средств)
     *
     * @param id
     * @param driverRequest
     * @return
     */
    @PutMapping("/{id}")
    @Operation(summary = "обновление  водителя(Основной упор на снятие и начисление средств)")
    public ResponseEntity<HttpStatus> updateDriver(@Parameter(description = "id  водителя") @PathVariable("id") Long id,
                                                   @RequestBody DriverRequest driverRequest) {
        driverService.updateDriver(id, driverRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
