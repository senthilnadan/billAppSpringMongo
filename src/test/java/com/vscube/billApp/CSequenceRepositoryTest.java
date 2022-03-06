package com.vscube.billApp;

import com.vscube.billApp.Service.repos.CSequenceRepository;
import com.vscube.billApp.domain.CSequence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;

@SpringBootTest
public class CSequenceRepositoryTest {

    @Autowired
    CSequenceRepository cSequenceRepository;



}
