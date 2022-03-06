package com.vscube.billApp.Service.controller;

import com.vscube.billApp.Service.repos.AuthorRepository;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("app")
public class AuthorRestController {

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("authors/{authodId}")
    public Author getAuthorById(@PathVariable(required = true, name = "authodId") Long authodId){
        Optional<Author> authorOptional = authorRepository.findById(authodId);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }else{
            return null;
        }
    }

    @GetMapping("authors")
    public List<Author> getAuthors(){
        List<Author> authorList = authorRepository.findAll();
        return  authorList;
    }

    @PostMapping("authors")
    public Author insertAuthor(@RequestBody Author author){
        System.out.println(author.toString());
        author.setId(0l);
        Author bookInserted = authorRepository.insert(author);
        return bookInserted;
    }

}
