package com.example.estarepository.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Timestamp createdOn;
    @Column(nullable = false)
    private Integer usageCounter;
    @Column(nullable = false)
    private String fileName;
    @ElementCollection
    private List<String> keywords;
}
