package com.example.vertualbookstore.service;

import com.example.vertualbookstore.entity.Book;
import com.example.vertualbookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final BookRepository bookRepository;

    public List<Book> recommendByCategory(String category) {
        return bookRepository.findByCategory(category);
    }
}
