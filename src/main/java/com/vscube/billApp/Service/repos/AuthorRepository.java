package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.book.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends MongoRepository<Author, Long> {
    public List<Author> findByName(String author);
}
