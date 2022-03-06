package com.vscube.billApp;

import com.vscube.billApp.Service.repos.AuthorRepository;
import com.vscube.billApp.Service.repos.BookRepository;
import com.vscube.billApp.Service.repos.PublisherRepository;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Book;
import com.vscube.billApp.domain.book.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Test
    public void createBook(){
        Book book = new Book();
        book.setName("My Book");
        book.setDescription("My Description");
        Author author = authorRepository.findById(1l).get();
        book.setAuthor(author);
        Publisher publisher = publisherRepository.findById(1l).get();
        book.setPublisher(publisher);
        book.setId(0l);
        bookRepository.insert(book);
    }

    @Test
    public void createMissingBook(){
        Book book = new Book();
        book.setName("117 NANNERY KATHAIKAL");
        book.setDescription("117 NANNERY KATHAIKAL");
        Author author = authorRepository.findById(3l).get();
        book.setAuthor(author);
        Publisher publisher = publisherRepository.findById(3l).get();
        book.setPublisher(publisher);
        book.setId(0l);
        book.setPrice(70.00);
        bookRepository.insert(book);
    }

    @Test
    public void createMissingBook2(){
        Book book = new Book();
        book.setName("JEN KATHAGAL");
        book.setDescription("JEN KATHAGAL");
        Author author = authorRepository.findById(3l).get();
        book.setAuthor(author);
        Publisher publisher = publisherRepository.findById(3l).get();
        book.setPublisher(publisher);
        book.setId(0l);
        book.setPrice(150.00);
        book.setKeyCode("543");
        bookRepository.insert(book);
    }

    @Test
    public void createMissingBook3(){
        Book book = new Book();
        book.setName("PUTTHA JATHAKA KATAHIGAL");
        book.setDescription("PUTTHA JATHAKA KATAHIGAL");
        Author author = authorRepository.findById(3l).get();
        book.setAuthor(author);
        Publisher publisher = publisherRepository.findById(3l).get();
        book.setPublisher(publisher);
        book.setId(0l);
        book.setPrice(150.00);
        book.setKeyCode("545");
        bookRepository.insert(book);
    }


    @Test
    public void createMissingBook4(){
        Book book = new Book();
        book.setName("AASAI PERAASAI");
        book.setDescription("AASAI PERAASAI");
        Author author = authorRepository.findById(3l).get();
        book.setAuthor(author);
        Publisher publisher = publisherRepository.findById(3l).get();
        book.setPublisher(publisher);
        book.setId(0l);
        book.setPrice(30.00);
        book.setKeyCode("586");
        bookRepository.insert(book);
    }

    @Test
    public void createMissingBook5(){
        Book book = new Book();
        book.setName("KURIPPARITHAL");
        book.setDescription("KURIPPARITHAL");
        Author author = authorRepository.findById(3l).get();
        book.setAuthor(author);
        Publisher publisher = publisherRepository.findById(3l).get();
        book.setPublisher(publisher);
        book.setId(0l);
        book.setPrice(30.00);
        book.setKeyCode("590");
        bookRepository.insert(book);
    }
}
