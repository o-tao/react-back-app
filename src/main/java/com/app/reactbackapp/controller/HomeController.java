package com.app.reactbackapp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "Server Start!";
    }

    @GetMapping("/form1")
    public Map<String, String> form1(@RequestParam("name") String name,
                                     @RequestParam("password") String password) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("name", name);
        resultMap.put("password", password);

        return resultMap;
    }
}
