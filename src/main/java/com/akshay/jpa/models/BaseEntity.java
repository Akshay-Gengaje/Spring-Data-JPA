package com.akshay.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
    private Integer id;
    @CreatedDate
    @Column(updatable = false)
    LocalDateTime createdAt;
    @LastModifiedBy
    @Column(updatable = false)
    String createdBy;
    @LastModifiedDate
    @Column(insertable = false)
    LocalDateTime lastModifiedAt;
    @LastModifiedBy
    @Column(insertable = false)
    String lastModifiedBy;
}
