package ru.bondarev.car_driver.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.bondarev.car_driver.dto.request.DriverRequest;
import ru.bondarev.car_driver.dto.response.DriverResponse;
import ru.bondarev.car_driver.entity.Driver;

@Mapper(uses = { CarMapper.class })
public interface DriverMapper {

    DriverMapper INSTANCE = Mappers.getMapper( DriverMapper.class );

    @Mapping(source = "id", target = "id")
    DriverResponse toDTO(Driver driver);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "birthday", target = "birthday")
    @Mapping(source = "greenmoney", target = "greenmoney")
    Driver toEntity(DriverRequest driverRequest);
}
