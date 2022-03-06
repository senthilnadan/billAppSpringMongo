package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.CSequence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CSequenceRepository  extends MongoRepository<CSequence, String> {
}
