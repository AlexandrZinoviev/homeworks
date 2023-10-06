package netology.springBoot.homeworkTwo.controller;

import netology.springBoot.homeworkTwo.exception.InvalidCredentials;
import netology.springBoot.homeworkTwo.exception.UnauthorizedUser;
import netology.springBoot.homeworkTwo.model.Authorities;
import netology.springBoot.homeworkTwo.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidCredentials.class)
    public String handlerInvalidCredentials(InvalidCredentials e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUser.class)
    public String handlerUnauthorizedUser(UnauthorizedUser e) {
        return e.getMessage();
    }
}