package com.keyin.sprint.service;

import com.keyin.sprint.model.Car;
import com.keyin.sprint.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;  // Ensure this matches your JPA setup
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> searchCars(String make, String model, String year, String colour, Integer mileage) {
        return carRepository.findAll((Specification<Car>) (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (make != null && !make.isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("make"), make));
            }
            if (model != null && !model.isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("model"), model));
            }
            if (year != null && !year.isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("year"), year));
            }
            if (colour != null && !colour.isBlank()) {
                predicates.add(criteriaBuilder.equal(root.get("colour"), colour));
            }
            if (mileage != null) {
                predicates.add(criteriaBuilder.equal(root.get("mileage"), mileage));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
