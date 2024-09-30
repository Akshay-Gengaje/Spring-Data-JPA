package com.akshay.jpa.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Lecture extends BaseEntity{
    @ManyToOne
    @JoinColumn(name="section_id")
    private Section section;
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
