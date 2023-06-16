package ru.bondarev.car_driver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.car_driver.dto.request.CarPartRequest;
import ru.bondarev.car_driver.dto.response.CarPartResponse;
import ru.bondarev.car_driver.entity.CarPart;

@Mapper
public interface CarPartMapper {
    CarPartMapper INSTANCE = Mappers.getMapper( CarPartMapper.class );
    @Mapping(source = "id", target = "id")
    CarPartResponse toDTO(CarPart carPart);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "serialNumber", target = "serialNumber")
    @Mapping(source = "carId", target = "car.id")
    CarPart toEntity(CarPartRequest carPartRequest);
}
