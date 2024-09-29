package com.akshay.jpa.controller;

import com.akshay.jpa.models.Author;
import com.akshay.jpa.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }
    @PostMapping
    public Author createUser(@RequestBody Author author) {
       return authorService.createAuthor(author);
    }
}
