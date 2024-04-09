package com.keyin.sprint.controller;

import com.keyin.sprint.model.Car;
import com.keyin.sprint.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class CarControllerTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testDatabaseConnection() {
        // Assuming you have a car with ID 1 in your database for this test to work
        Optional<Car> car = carRepository.findById(1L);
        assert(car.isPresent()); // Simply checks that a car with ID 1 exists
    }
}
