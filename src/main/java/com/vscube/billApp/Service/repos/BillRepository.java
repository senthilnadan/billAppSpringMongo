package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.bill.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends MongoRepository<Invoice, Long> {

}
