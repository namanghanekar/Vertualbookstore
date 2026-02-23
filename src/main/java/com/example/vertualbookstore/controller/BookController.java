package com.example.vertualbookstore.controller;

import com.example.vertualbookstore.dto.BookRequest;
import com.example.vertualbookstore.dto.BookResponse;
import com.example.vertualbookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> create(
            @Valid @RequestBody BookRequest dto) {

        return new ResponseEntity<>(
                bookService.createBook(dto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAll() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}

