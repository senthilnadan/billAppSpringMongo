package com.vscube.billApp.Service.repos;


import com.vscube.billApp.domain.book.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository <Customer, Long> {
    List<Customer> findByAMCode(String customerCode);
}
