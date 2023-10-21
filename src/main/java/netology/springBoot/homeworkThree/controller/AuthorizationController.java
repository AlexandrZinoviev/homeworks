package netology.springBoot.homeworkThree.controller;

import netology.springBoot.homeworkThree.repository.Authorities;
import netology.springBoot.homeworkThree.service.AuthorizationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class AuthorizationController {
    private final AuthorizationService service;

    private AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
}