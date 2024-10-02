package com.app.reactbackapp.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class DataController {

    @GetMapping
    public Map<String, Object> Data(@RequestParam("page") String page) {
        Map<String, Object> resultMap = new HashMap<>();
        ArrayList<Map<String, Object>> array = new ArrayList<>();
        if ("1".equals(page)) {
            for (int i = 1; i <= 5; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", i);
                map.put("name", "data" + i);
                array.add(map);
            }
        }
        resultMap.put("page", page);
        resultMap.put("results", array);
        resultMap.put("total_pages", 3);
        return resultMap;
    }
}
