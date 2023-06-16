package ru.bondarev.car_driver.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.car_driver.dto.request.DriverRequest;
import ru.bondarev.car_driver.dto.response.DriverResponse;
import ru.bondarev.car_driver.entity.Car;
import ru.bondarev.car_driver.entity.Driver;
import ru.bondarev.car_driver.mapper.DriverMapper;
import ru.bondarev.car_driver.repository.DriverRepository;
import ru.bondarev.car_driver.service.DriverService;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriverServiceImp implements DriverService {

     private final DriverRepository driverRepository;

    private static Logger log = Logger.getLogger(DriverServiceImp.class.getName());

    @Override
    public DriverResponse getDriverById(Long id) {
        var driver = driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException("не найден водитель по id"));

        return DriverResponse.builder()
                .id(driver.getId())
                .name(driver.getName())
                .greenmoney(driver.getGreenmoney())
                .bluenmoney((driver.getGreenmoney()*0.6))
                .redmoney((driver.getGreenmoney()*0.4))
                .carsId(driver.getCars().stream()
                        .map(Car::getId)
                        .collect(Collectors.toList()))
                .birthday(driver.getBirthday())
                .build();
    }

    /**
     * вывод  в логи и на контроллер
     * @return
     */
    @Override
    public List<String> getNameBirthtdayDrivers() {
        LocalDate date = LocalDate.now();
        List<String>driversname = driverRepository.findByBirthday(date).stream()
                .map(Driver::getName).toList();
        log.info(String.valueOf(driversname));
        return driversname;
    }

    @Override
    public List<DriverResponse> getAllDriver() {
        return driverRepository.findAll().stream()
                .map(DriverMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveDriver(DriverRequest driverRequest) {
           driverRepository.save(DriverMapper.INSTANCE.toEntity(driverRequest));

    }

    @Override
    public void deleteDriver(Long id) {
          driverRepository.deleteById(id);
    }

    /**
     * обновление водителя. Основная цель начисление и снятие средств.
     * В энтити хранится все в зеленых долларах.
     * В реквесте должно прийти только изменение(можно и разными валютами расплатиться)!!
     * @param id
     * @param driverRequest
     */
    @Override
    public void updateDriver(Long id, DriverRequest driverRequest) {
        //конвертируем каждую валюту в зеленый доллар

        var driver = driverRepository.findById(id)
                .orElseThrow(()->new RuntimeException("не найден водитель по id"));
        Double greenmoney =driver.getGreenmoney()+(driverRequest.getBluenmoney()/0.6)+
                driverRequest.getGreenmoney()+ (driverRequest.getRedmoney()/0.4);
        driver.setGreenmoney(greenmoney);
        driverRepository.save(driver);
    }
}
