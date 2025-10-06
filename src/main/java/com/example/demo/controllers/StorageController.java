package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.services.StorageService;

@RestController
@RequestMapping("/api/storage")
public class StorageController {
    
    @Autowired
    private StorageService storageService;
    
    // Author endpoints
    @PostMapping("/authors")
    public ResponseEntity<String> createAuthor(@RequestBody Map<String, String> request) {
        try {
            String name = request.get("name");
            storageService.createAuthor(name);
            return ResponseEntity.ok("Author created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating author: " + e.getMessage());
        }
    }
    
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.ok(storageService.getAllAuthors());
    }
    
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable UUID id) {
        Author author = storageService.getAuthorById(id);
        if (author != null) {
            return ResponseEntity.ok(author);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/authors/{id}")
    public ResponseEntity<String> updateAuthor(@PathVariable UUID id, @RequestBody Map<String, String> request) {
        try {
            String newName = request.get("name");
            storageService.updateAuthor(id, newName);
            return ResponseEntity.ok("Author updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating author: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable UUID id) {
        try {
            storageService.deleteAuthor(id);
            return ResponseEntity.ok("Author deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting author: " + e.getMessage());
        }
    }
    
    // Book endpoints
    @PostMapping("/books")
    public ResponseEntity<String> createBook(@RequestBody Map<String, String> request) {
        try {
            String title = request.get("title");
            UUID authorId = UUID.fromString(request.get("authorId"));
            storageService.createBook(title, authorId);
            return ResponseEntity.ok("Book created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating book: " + e.getMessage());
        }
    }
    
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(storageService.getAllBooks());
    }
    
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = storageService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/books/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Map<String, String> request) {
        try {
            String newTitle = request.get("title");
            storageService.updateBook(id, newTitle);
            return ResponseEntity.ok("Book updated successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating book: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        try {
            storageService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting book: " + e.getMessage());
        }
    }
}
