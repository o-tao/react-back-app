package com.app.reactbackapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class DataController {

    @GetMapping
    public Map<String, Object> Data(@RequestParam("page") String page) {
        System.out.println(page);
        return null;
    }
}
