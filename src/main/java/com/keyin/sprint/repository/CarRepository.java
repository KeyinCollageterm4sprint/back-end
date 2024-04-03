package com.keyin.sprint.repository;

import com.keyin.sprint.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    // Additional query methods can be defined here
}
