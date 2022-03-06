package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.book.Publisher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PublisherRepository extends MongoRepository<Publisher, Long> {
   public List<Publisher> findByName(String group);
}
