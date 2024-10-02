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
        int start = 0;
        int end = 0;
        if ("1".equals(page)) {
            start = 1;
            end = 5;
        }
        if ("2".equals(page)) {
            start = 6;
            end = 10;
        }
        if ("3".equals(page)) {
            start = 11;
            end = 15;
        }
        array = getData(start, end);
        resultMap.put("page", Integer.parseInt(page));
        resultMap.put("results", array);
        resultMap.put("total_pages", 3);
        return resultMap;
    }

    private ArrayList<Map<String, Object>> getData(int start, int end) {
        ArrayList<Map<String, Object>> array = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", i);
            map.put("name", "data" + i);
            array.add(map);
        }
        return array;
    }
}
