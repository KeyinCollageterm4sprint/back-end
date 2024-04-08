package com.keyin.sprint.service;

import com.keyin.sprint.model.SearchHistory;
import com.keyin.sprint.repository.SearchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SearchHistoryService {

    private final SearchHistoryRepository searchHistoryRepository;

    @Autowired
    public SearchHistoryService(SearchHistoryRepository searchHistoryRepository) {
        this.searchHistoryRepository = searchHistoryRepository;
    }

    public void logSearch(Long userId, String searchQuery) {
        SearchHistory searchHistory = new SearchHistory(userId, searchQuery, LocalDateTime.now());
        searchHistoryRepository.save(searchHistory);
    }

    public List<SearchHistory> getUserSearchHistory(Long userId) {
        return searchHistoryRepository.findByUserId(userId);
    }
}
