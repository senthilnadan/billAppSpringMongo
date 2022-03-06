package com.vscube.billApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;

public class AbstractMongoService {

    @Value("${mongo.database}")
    private String database;

    @Autowired
    protected MongoOperations mongoOperations;

    public AbstractMongoService() {
    }


}
