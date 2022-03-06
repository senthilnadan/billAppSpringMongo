package com.vscube.billApp;

import com.vscube.billApp.Service.repos.PublisherRepository;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublisherRepositoryTest {

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    public void addPublisher(){
        Publisher publisher = new Publisher();
        publisher.setId(0l);
        publisher.setName("NANMOZHE PATHIPAGAM");

        publisherRepository.insert(publisher);
    }


}
