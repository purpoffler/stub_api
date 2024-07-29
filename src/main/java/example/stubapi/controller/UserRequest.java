package example.stubapi.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotBlank;


public class UserRequest {

    @NotBlank(message = "Поле login не может быть пустым")
    private String login;

    @NotBlank(message = "Поле password не может быть пустым")
    private String password;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
