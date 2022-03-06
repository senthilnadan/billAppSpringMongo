package com.vscube.billApp.tools.csv;

import com.vscube.billApp.Service.repos.AuthorRepository;
import com.vscube.billApp.Service.repos.BookRepository;
import com.vscube.billApp.Service.repos.CustomerRepository;
import com.vscube.billApp.Service.repos.PublisherRepository;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Book;
import com.vscube.billApp.domain.book.Customer;
import com.vscube.billApp.domain.book.Publisher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.util.List;

import static com.vscube.billApp.tools.csv.BookCSVReader.parseCSVWithHeaderForAccount;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookCSVReaderTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Test
    public void readCSVFile() throws Exception {
        List<ItemModelFromOldDB> itemModelFromOldDBS = BookCSVReader.parseCSVWithHeader("PM2122QueryNanmozhe.csv");
        for (ItemModelFromOldDB it : itemModelFromOldDBS) {
            createBook(it);
        }


    }

    @Test
    public void readCSVAccountFile() throws Exception{

        List<AccountModelFromOldDB> itemModelFromOldDBS = parseCSVWithHeaderForAccount("Accounts.csv");
        for (AccountModelFromOldDB it : itemModelFromOldDBS) {
            createAccount(it);

        }
    }

    private void createAccount(AccountModelFromOldDB it) {
        Customer account = converCSVROWToCustomer(it);
        customerRepository.insert(account);
    }

    private Customer converCSVROWToCustomer(AccountModelFromOldDB it) {
        Customer customer = new Customer();
        customer.setId(0l);
        customer.setIdGST(it.GST);
        customer.setName(it.name);
        customer.setAddress(it.address);
        customer.setFax(it.fax);
        customer.setPhone(it.phone);
        customer.setAMCode(it.code);
        customer.setContact(it.contact);
        return customer;
    }

    private void createBook(ItemModelFromOldDB it) throws Exception {
        Book book = converCSVROWToBook(it);
        System.out.println(it);
    }

    private Book converCSVROWToBook(ItemModelFromOldDB it) throws Exception {

        List<Author> authorListByName = authorRepository.findByName(it.author);
        if(authorListByName.size() < 1) throw  new Exception("Author Not Found Exception" + it.author);
        if(authorListByName.size() > 1) throw  new Exception("Too Many Author With Name " + it.author);
        Author myAuthor = authorListByName.get(0);
        List<Publisher> publishers = publisherRepository.findByName(it.group);
        if(publishers.size() < 1) throw  new Exception("publisher Not Found Exception " + it.group );
        if(publishers.size() > 1) throw  new Exception("Too Many publisher With Name " + it.group);
        Publisher publisher = publishers.get(0);
        Book book = new Book();
        book.setISBN(it.isbn);
        book.setPublisher(publisher);
        book.setAuthor(myAuthor);
        book.setName(it.name);
        book.setId(0l);
        book.setKeyCode(it.code);
        book.setPrice(it.rate);
        return bookRepository.insert(book);


    }
}