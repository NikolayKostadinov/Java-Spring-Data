package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.CarSeedDto;
import softuni.exam.models.entities.Car;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.FileService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    public static final String CARS_FILE_PATH = "src/main/resources/files/json/cars.json";
    private final CarRepository repository;
    private final FileService fileService;
    private final ModelMapper mapper;
    private final ValidationUtil validator;

    @Autowired
    public CarServiceImpl(CarRepository repository, FileService fileService, ModelMapper mapper, ValidationUtil validator) {
        this.repository = repository;
        this.fileService = fileService;
        this.mapper = mapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return this.repository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuffer response = new StringBuffer();
        List<Car> cars = Arrays.stream(
                        this.fileService
                                .readJsonFile(CARS_FILE_PATH, CarSeedDto[].class))
                .filter(c -> {
                    boolean valid = this.validator.isValid(c);
                    response.append(valid ? String.format("Successfully imported car - %s %s", c.getMake(), c.getModel())
                                    : "Invalid car")
                            .append(System.lineSeparator());
                    return valid;
                })
                .map(c -> this.mapper.map(c, Car.class))
                .collect(Collectors.toList());
        this.repository.saveAll(
                cars);
        return response.toString().trim();
    }


    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        return null;
    }
}
