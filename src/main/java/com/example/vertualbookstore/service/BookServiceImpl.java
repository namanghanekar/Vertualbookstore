package com.example.vertualbookstore.service;

import com.example.vertualbookstore.dto.BookRequest;
import com.example.vertualbookstore.dto.BookResponse;
import com.example.vertualbookstore.entity.Book;
import com.example.vertualbookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service   // 🔥 VERY IMPORTANT
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookResponse createBook(BookRequest request) {

        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setCategory(request.getCategory());
        book.setDescription(request.getDescription());
        book.setPrice(request.getPrice());

        Book saved = bookRepository.save(book);

        return mapToResponse(saved);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private BookResponse mapToResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getDescription(),
                book.getPrice()
        );
    }
}
