package com.keyin.sprint.service;

import com.keyin.sprint.model.Car;
import com.keyin.sprint.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<Car> searchCars(String make, String model) {
        return carRepository.findByMakeAndModel(make, model);
    }
}
