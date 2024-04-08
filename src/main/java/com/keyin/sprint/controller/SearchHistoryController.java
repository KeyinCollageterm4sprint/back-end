// File: src/main/java/com/keyin/sprint/controller/SearchHistoryController.java

package com.keyin.sprint.controller;

import com.keyin.sprint.model.SearchHistory;
import com.keyin.sprint.service.SearchHistoryService; // You may need to create this service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/history")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryService searchHistoryService;

    @GetMapping
    public ResponseEntity<List<SearchHistory>> getSearchHistory(Long userId) {
        List<SearchHistory> history = searchHistoryService.getUserSearchHistory(userId);
        return ResponseEntity.ok(history);
    }
}
