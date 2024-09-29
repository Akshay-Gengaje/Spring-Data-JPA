package com.akshay.jpa.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Lecture {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name="section_id")
    private Section section;
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
