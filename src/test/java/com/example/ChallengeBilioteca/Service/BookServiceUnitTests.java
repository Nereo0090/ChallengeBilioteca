package com.example.ChallengeBilioteca.Service;

import com.example.ChallengeBilioteca.Exception.BookNotFoundException;
import com.example.ChallengeBilioteca.Model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceTest {

    private BookService bookService;

    @BeforeEach
    void setUp() {
        bookService = new BookService(); // usa tu lista interna
    }

    @Test
    void testGetAllBooks() {
        List<Book> books = bookService.getAllBooks();
        assertEquals(3, books.size());
    }

    @Test
    void testGetBookByIdFound() {
        Book book = bookService.getBookById(1);
        assertEquals("Clean Code", book.getTitle());
    }

    @Test
    void testGetBookByIdNotFound() {
        assertThrows(BookNotFoundException.class, () -> bookService.getBookById(999));
    }

    @Test
    void testAddBook() {
        Book newBook = new Book(4L, "Test Driven Development", "Kent Beck", 2002);
        Book added = bookService.addBook(newBook);
        assertEquals(newBook, added);
        assertEquals(4, bookService.getAllBooks().size());
    }
}