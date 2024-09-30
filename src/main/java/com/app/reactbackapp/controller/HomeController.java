package com.app.reactbackapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
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

    @PostMapping("/form2")
    public Map<String, String> form2(@RequestBody Map<String, String> resultMap) {

        return resultMap;
    }

}
