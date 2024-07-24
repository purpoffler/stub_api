package com.example.stubapi.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class StubController {

    @GetMapping("/getData")
    public String getData() {
        return "{\"message\":\"СТАТИЧНЫЙ ОТВЕТ\"}";
    }

    @PostMapping("/postData")
    public Map<String, Object> postData(@RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        response.put("login", request.get("login"));
        response.put("password", request.get("password"));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        response.put("date", formattedDate);

        try {
            Random random = new Random();
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return response;
    }
}


