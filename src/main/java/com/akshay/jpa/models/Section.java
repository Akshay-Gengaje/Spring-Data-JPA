package com.akshay.jpa.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Section {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int sectionOrder;
    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
