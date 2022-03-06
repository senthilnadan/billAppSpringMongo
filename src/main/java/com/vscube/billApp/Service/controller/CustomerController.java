package com.vscube.billApp.Service.controller;


import com.vscube.billApp.Service.repos.BookRepository;
import com.vscube.billApp.Service.repos.CustomerRepository;
import com.vscube.billApp.domain.book.Book;
import com.vscube.billApp.domain.book.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("app")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("customers/{id}")
    public Customer getBookById(@PathVariable(required = true, name = "id") Long id){
        Optional<Customer> authorOptional = customerRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }else{
            return null;
        }
    }

    @GetMapping("customers")
    public List<Customer> getAuthors(){
        List<Customer> authorList = customerRepository.findAll();
        return  authorList;
    }

    @PostMapping("customers")
    public Customer insertBook(@RequestBody Customer book){
        System.out.println(book.toString());
        Customer bookInserted = customerRepository.insert(book);
        return bookInserted;
    }

    @PatchMapping("customers/{id}")
    public Customer insertBook(@PathVariable(required = true, name = "id") Long id, @RequestBody Customer customer){
        Customer existingCustomer ;
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if(customerOptional.isPresent()){
            existingCustomer =  customerOptional.get();
        }else{
            return null;
        }

        System.out.println(customer.toString());
        if(existingCustomer.getName() != customer.getName()) existingCustomer.setName(customer.getName());
        if(existingCustomer.getAddress() != customer.getAddress()) existingCustomer.setAddress(customer.getAddress());
        if(existingCustomer.getEmail() != customer.getEmail()) existingCustomer.setEmail(customer.getEmail());
        if(existingCustomer.getIdGST() != customer.getIdGST()) existingCustomer.setIdGST(customer.getIdGST());
        Customer bookInserted = customerRepository.save(existingCustomer);
        return bookInserted;
    }
}
