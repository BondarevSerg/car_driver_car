package ru.bondarev.car_driver.service.Imp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.bondarev.car_driver.dto.request.CarPartRequest;
import ru.bondarev.car_driver.dto.response.CarPartResponse;
import ru.bondarev.car_driver.mapper.CarPartMapper;
import ru.bondarev.car_driver.repository.CarPartRepository;
import ru.bondarev.car_driver.service.CarPartService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarPartServiceImp implements CarPartService {

    private final CarPartRepository carPartRepository;

    @Override
    public CarPartResponse getCarPartById(Long id) {
        var carPart = carPartRepository.findById(id)
                .orElseThrow(()->new RuntimeException("не найден авто по id"));
        return CarPartMapper.INSTANCE.toDTO(carPart);
    }

    @Override
    public List<CarPartResponse> getAllCarPart() {
        return carPartRepository.findAll().stream()
                .map(CarPartMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCarPart(CarPartRequest carPartRequest) {
           carPartRepository.save(CarPartMapper.INSTANCE.toEntity(carPartRequest));
    }

    @Override
    public void deleteCarPart(Long id) {
     carPartRepository.deleteById(id);
    }
}
