package com.example.estarepository.activity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class Activity {
    private String title;
    private Timestamp createdOn;
    private Integer usageCounter;
    private String[] keywords;
}
