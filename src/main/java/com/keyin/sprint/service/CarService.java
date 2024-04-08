package com.keyin.sprint.service;

import com.keyin.sprint.model.Car;
import com.keyin.sprint.model.SearchHistory;
import com.keyin.sprint.repository.CarRepository;
import com.keyin.sprint.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final SearchHistoryRepository searchHistoryRepository;
    private final UserService userService; // Assuming you have a UserService to manage user-related operations

    @Autowired
    public CarService(CarRepository carRepository, SearchHistoryRepository searchHistoryRepository, UserService userService) {
        this.carRepository = carRepository;
        this.searchHistoryRepository = searchHistoryRepository;
        this.userService = userService;
    }

    public List<Car> searchCars(String username, String make, String model, String year, Integer mileage, String colour) {
        Long userId = userService.findUserIdByUsername(username); // Obtain user ID from username
        if(userId != null) {
            logSearch(userId, String.format("make: %s, model: %s, year: %s, colour: %s", make, model, year, colour));
            return carRepository.findByMakeAndModelAndYearAndColour(make, model, year, colour);
        }
        return List.of(); // Return empty list if user ID is not found
    }
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    private void logSearch(Long userId, String searchTerm) {
        SearchHistory searchHistory = new SearchHistory(userId, searchTerm, LocalDateTime.now());
        searchHistoryRepository.save(searchHistory);
    }
}
