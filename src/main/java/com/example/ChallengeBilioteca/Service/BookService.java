package com.example.ChallengeBilioteca.Service;

import com.example.ChallengeBilioteca.Exception.BookNotFoundException;
import org.springframework.stereotype.Service;
import com.example.ChallengeBilioteca.Model.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    public BookService() {
        books.add(new Book(1L, "Clean Code", "Robert C. Martin", 2008));
        books.add(new Book(2L, "Effective Java", "Joshua Bloch", 2018));
        books.add(new Book(3L, "The Pragmatic Programmer", "Andrew Hunt", 1999));
    }

    public List<Book> getAllBooks() {
        return books;
    }
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(id));
    }
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }
    public Book updateBook(int id, Book updatedBook) {
        Book existingBook = books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setYear(updatedBook.getYear());

        return existingBook;
    }

    public void deleteBook(int id) {
        Book existingBook = books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(id));

        books.remove(existingBook);
    }
}
