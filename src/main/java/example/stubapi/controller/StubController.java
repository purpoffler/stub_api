package example.stubapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.springframework.http.ResponseEntity.badRequest;

@RestController
@RequestMapping("/api")
public class StubController {

    DataBase db = new DataBase();
    Date current = new Date();
    SimpleDateFormat f = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
    String date = f.format(current);

    @GetMapping("/getData")
    public ResponseEntity<?> getData(@RequestParam String login) {
        try {
            Random random = new Random();
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            User user = db.select(login);
            return new ResponseEntity<>(user.toString(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Такого логина не существует", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/postData")
    public ResponseEntity<?> postData(@Valid @RequestBody UserRequest request) {

        User user = new User(request.getLogin(), request.getPassword(), date, request.getEmail());


        try {
            Random random = new Random();
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            int numb = db.insert(user);

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("Количество измененных строк - ", numb);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Неверные данные", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/postDataMap")
    public ResponseEntity<Object> postData(@RequestBody Map<String, String> request) {


        if (request.size() != 3) {
            return new ResponseEntity<>("Передано неправильное количество полей", HttpStatus.BAD_REQUEST);
        }

        if (request.get("login").isEmpty() && request.get("password").isEmpty() && request.get("email").isEmpty()) {
            return new ResponseEntity<>("Поле login, password или email - пустое", HttpStatus.BAD_REQUEST);
        }

        User user = new User(request.get("login"), request.get("password"), date, request.get("email"));

        try {
            Random random = new Random();
            Thread.sleep(1000 + random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            int numb = db.insert(user);

            Map<String, Object> response = new HashMap<>();
            response.put("user", user);
            response.put("Количество измененных строк - ", numb);

            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>("Неверные данные", HttpStatus.BAD_REQUEST);
        }


    }
}






