package com.example.stubapi.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@RestController

@RequestMapping("/api")
public class StubController {


    @GetMapping("/getData")
    public String getData() {
        return "{\"message\":\"This is a static JSON response\"}";
    }


    @PostMapping("/postData")
    public Map<String, Object> postData(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("login", request.get("login"));
        response.put("password", request.get("password"));
        response.put("date", new Date());
        try {
            Thread.sleep(1000 + (int)(Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }
}
