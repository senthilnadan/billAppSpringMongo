package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.book.Publisher;
import com.vscube.billApp.domain.book.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByEmail(String emailId);
}
