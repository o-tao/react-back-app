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
        ArrayList<Map<String, Object>> array;
        int end = 0;
        if ("1".equals(page)) {
            end = 5;
        }
        if ("2".equals(page)) {
            end = 10;
        }
        if ("3".equals(page)) {
            end = 15;
        }
        array = getData(end);
        resultMap.put("page", Integer.parseInt(page));
        resultMap.put("results", array);
        resultMap.put("total_pages", 3);
        return resultMap;
    }

    private ArrayList<Map<String, Object>> getData(int end) {
        ArrayList<Map<String, Object>> array = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("name", "data" + i);
            array.add(map);
        }
        return array;
    }
}
