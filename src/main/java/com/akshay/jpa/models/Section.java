package com.akshay.jpa.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Section extends BaseEntity{
    private String name;
    private int sectionOrder;
    @ManyToOne()
    @JoinColumn(name = "course_id")
    private Course course;
    @OneToMany(mappedBy = "section")
    private List<Lecture> lectures;
}
