package com.example.library_system.service;

import com.example.library_system.model.Book;
import com.example.library_system.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // GET ALL BOOKS
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // GET BOOK BY ID
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // CREATE BOOK
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // UPDATE BOOK
    public Book updateBook(Long id, Book bookDetails) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublicationYear(bookDetails.getPublicationYear());

        return bookRepository.save(book);
    }

    // DELETE BOOK
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}