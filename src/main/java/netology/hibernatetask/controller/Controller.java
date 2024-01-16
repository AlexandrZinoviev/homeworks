package netology.hibernatetask.controller;


import netology.hibernatetask.Person;
import netology.hibernatetask.repository.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPerson(@RequestParam("city") String city) {
        return repository.getByCity(city);
    }
}