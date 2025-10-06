package com.example.demo.models;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.interfaces.StorageItf;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;

@Component
public class StorageModel implements StorageItf {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Autowired
    public StorageModel(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void createAuthor(String name) {
        Author author = new Author();
        author.setName(name);

        authorRepository.save(author);
    }

    @Override
    public void createBook(String title, Author author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        bookRepository.save(book);
    }

    @Override
    public Author findAuthorById(UUID id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteAuthorById(UUID id) {
        authorRepository.deleteById(id);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void updateAuthor(UUID id, String newName) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(newName);
            authorRepository.save(author);
        }
    }

    @Override
    public void updateBook(Long id, String newTitle) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(newTitle);
            bookRepository.save(book);
        }
    }
}
