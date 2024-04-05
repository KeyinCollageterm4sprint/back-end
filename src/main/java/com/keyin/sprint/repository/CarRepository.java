package com.keyin.sprint.repository;

import com.keyin.sprint.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMakeAndModel(String make, String model);
}
