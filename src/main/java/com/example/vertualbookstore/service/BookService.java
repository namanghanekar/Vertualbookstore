package com.example.vertualbookstore.service;

import com.example.vertualbookstore.dto.BookRequest;
import com.example.vertualbookstore.dto.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse createBook(BookRequest dto);

    List<BookResponse> getAllBooks();
}
