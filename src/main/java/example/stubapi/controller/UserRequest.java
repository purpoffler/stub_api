package example.stubapi.controller;


import javax.validation.constraints.NotBlank;


public class UserRequest {

    @NotBlank(message = "Поле login не может быть пустым")
    private String login;

    @NotBlank(message = "Поле password не может быть пустым")
    private String password;

    @NotBlank(message = "Поле email не может быть пустым")
    private String email;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
