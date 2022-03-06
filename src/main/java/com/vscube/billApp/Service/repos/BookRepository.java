package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Long> {
    List<Book> findByKeyCode(String productCode);
}
