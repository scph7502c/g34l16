package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SumController {

    @GetMapping("/sum")
    public int calculateSum(@RequestParam List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }
}