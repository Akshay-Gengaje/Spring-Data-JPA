package com.akshay.jpa.service;

import com.akshay.jpa.models.Author;
import com.akshay.jpa.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service

public class AuthorService {
    private final AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(@RequestBody Author author){
        try {
            return authorRepository.save(author);
        } catch (Exception ex) {
           throw new RuntimeException(ex.getMessage());
        }
    }
}
