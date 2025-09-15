package com.example.ChallengeBilioteca.Exeption; // <- ojo al typo, mejor poner "Exception"

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(int id) {
        super("Book with ID " + id + " not found");
    }
}
