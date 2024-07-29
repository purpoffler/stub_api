package com.example.stubapi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String login;
    public String password;
    public String date;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.date = now.format(formatter);
    }
}
