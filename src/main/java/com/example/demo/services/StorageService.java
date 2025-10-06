package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.interfaces.StorageItf;

@Service
public class StorageService {

    private StorageItf storage;

    public StorageService(StorageItf storage) {
        this.storage = storage;
    }
    
    public void createAuthor(String name) {
        storage.createAuthor(name);
    }
    
    public void createBook(String title, UUID authorId) {
        Author author = storage.findAuthorById(authorId);
        if (author != null) {
            storage.createBook(title, author);
        } else {
            throw new RuntimeException("Author not found with id: " + authorId);
        }
    }
    
    public Author getAuthorById(UUID id) {
        return storage.findAuthorById(id);
    }
    
    public Book getBookById(Long id) {
        return storage.findBookById(id);
    }
    
    public List<Author> getAllAuthors() {
        return storage.getAllAuthors();
    }

    public List<Book> getAllBooks() {
        return storage.getAllBooks();
    }

    public void deleteAuthor(UUID id) {
        storage.deleteAuthorById(id);
    }
    
    public void deleteBook(Long id) {
        storage.deleteBookById(id);
    }
    
    public void updateAuthor(UUID id, String newName) {
        storage.updateAuthor(id, newName);
    }
    
    public void updateBook(Long id, String newTitle) {
        storage.updateBook(id, newTitle);
    }
}
