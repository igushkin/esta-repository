package com.example.estarepository.activity.controller;

import com.example.estarepository.activity.Activity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/activities")
public class ActivityController {

    @GetMapping
    public List<Activity> get() {
        return List.of();
    }
}
