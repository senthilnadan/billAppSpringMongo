package com.vscube.billApp.Service.controller;


import com.vscube.billApp.Service.repos.AuthorRepository;
import com.vscube.billApp.Service.repos.PublisherRepository;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("app")
public class PublisherController {

    @Autowired
    PublisherRepository publisherRepository;

    @GetMapping("publishers/{id}")
    public Publisher getAuthorById(@PathVariable(required = true, name = "id") Long authodId){
        Optional<Publisher> authorOptional = publisherRepository.findById(authodId);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }else{
            return null;
        }
    }

    @GetMapping("publishers")
    public List<Publisher> getPublishers(){
        List<Publisher> authorList = publisherRepository.findAll();
        return  authorList;
    }

    @PostMapping("publishers")
    public Publisher insertPublisher(@RequestBody Publisher author){
        System.out.println(author.toString());
        author.setId(0l);
        Publisher bookInserted = publisherRepository.insert(author);
        return bookInserted;
    }
}
