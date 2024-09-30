package com.akshay.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author extends BaseEntity{
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
