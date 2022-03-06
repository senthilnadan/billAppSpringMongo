package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.book.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  DatabaseSequenceRepository extends MongoRepository <DatabaseSequence,String> {

}
