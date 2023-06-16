package ru.bondarev.car_driver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.car_driver.dto.request.CarRequest;
import ru.bondarev.car_driver.dto.response.CarResponse;
import ru.bondarev.car_driver.entity.Car;

@Mapper(uses = { CarPartMapper.class })
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );
    @Mapping(source = "id", target = "id")
    @Mapping(source = "driver.id", target = "driverId")
    CarResponse toDTO(Car car);


    @Mapping(source = "driverId", target = "driver.id")
    Car toEntity(CarRequest carRequest);


}
