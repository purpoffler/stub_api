package example.stubapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class StubController {

    @GetMapping("/getData")
    public ResponseEntity<String> getData() {
        try {
            Random random = new Random();
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("{\"message\":\"СТАТИЧНЫЙ ОТВЕТ\"}", HttpStatus.OK);
    }

    @PostMapping("/postData")
    public ResponseEntity<Object> postData(@Valid @RequestBody UserRequest request) {
        User user = new User(request.getLogin(), request.getPassword());

        try {
            Random random = new Random();
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/postDataMap")
    public ResponseEntity<Object> postData(@RequestBody Map<String, String> request) {

        if (request.size() != 2) {
            return new ResponseEntity<>("Передано неправильное количество полей", HttpStatus.BAD_REQUEST);
        }

        if (request.get("login").isEmpty() && request.get("password").isEmpty()) {
            return new ResponseEntity<>("Поле login или password - пустые", HttpStatus.BAD_REQUEST);
        }

        User user = new User(request.get("login"), request.get("password"));

        try {
            Random random = new Random();
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}






