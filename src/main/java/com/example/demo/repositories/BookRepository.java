package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
