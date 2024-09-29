package com.akshay.jpa.models;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
//    @GeneratedValue(
//        strategy = GenerationType.SEQUENCE,
//        generator = "author_sequence"
//    )
//    @SequenceGenerator(
//            name = "author_sequence",
//            sequenceName = "author_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue
    private Integer id;
    @Column(length = 35)
    private String firstName;
    @Column(length = 35)
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;

    // Many-to-Many relationship between author and courses;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
