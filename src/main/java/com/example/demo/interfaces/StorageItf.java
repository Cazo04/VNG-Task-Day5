package com.example.demo.interfaces;

import java.util.List;
import java.util.UUID;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;

public interface StorageItf {
    List<Author> getAllAuthors();
    List<Book> getAllBooks();
    void createAuthor(String name);
    void createBook(String title, Author author);
    Author findAuthorById(UUID id);
    Book findBookById(Long id);
    void deleteAuthorById(UUID id);
    void deleteBookById(Long id);
    void updateAuthor(UUID id, String newName);
    void updateBook(Long id, String newTitle);
}
