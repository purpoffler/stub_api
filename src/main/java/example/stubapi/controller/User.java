package example.stubapi.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class User {

    public String login;
    public String password;
    public Timestamp date;
    public String email;


    public User(String login, String password, String date, String email){
        this.login = login;
        this.password = password;
        this.date = Timestamp.valueOf(date);
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", date='" + date + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
