package com.vscube.billApp;

import com.vscube.billApp.Service.repos.AuthorRepository;
import com.vscube.billApp.domain.book.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void addAuthor(){
        Author author = new Author();
        author.setId(0l);
        author.setName("AROKKEYA NAATHAN");

        authorRepository.insert(author);
    }
}
