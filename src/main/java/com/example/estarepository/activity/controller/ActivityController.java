package com.example.estarepository.activity.controller;

import com.example.estarepository.activity.Activity;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController("/activities")
public class ActivityController {
    @GetMapping
    public ResponseEntity<List<Activity>> findAll(@RequestParam(required = false) String text,
                                                  @RequestParam(defaultValue = "EVENT_DATE") String sort,
                                                  @RequestParam(defaultValue = "0") @PositiveOrZero int from,
                                                  @RequestParam(defaultValue = "10") @Positive int size) {

        return ResponseEntity.ok(List.of());
    }

}
