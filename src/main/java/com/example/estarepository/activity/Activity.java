package com.example.estarepository.activity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Instant createdOn;
    @Column(nullable = false)
    private Integer usageCounter;
    @Column(nullable = false)
    private String fileName;
    @ElementCollection
    private List<String> keywords;
}
