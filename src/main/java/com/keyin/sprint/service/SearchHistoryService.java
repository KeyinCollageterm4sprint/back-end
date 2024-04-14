package com.keyin.sprint.service;

import com.keyin.sprint.model.SearchHistory;
import com.keyin.sprint.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryService {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @Autowired
    private UserService userService;

    public List<SearchHistory> getUserSearchHistory(String username) {
        Long userId = userService.findUserIdByUsername(username);
        return searchHistoryRepository.findByUserId(userId);
    }
}
