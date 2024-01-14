package netology.hibernatetask.controller;

import netology.hibernatetask.dao.Person;
import netology.hibernatetask.request.PersonRequest;
import netology.hibernatetask.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }


    @GetMapping("/by-city")
    public ResponseEntity<List<Person>> getPersonByCity(@RequestParam("city") String city) {
        return ResponseEntity.ok(service.getPersonsByCity(city));
    }

    @GetMapping("/by-age-order-asc")
    public ResponseEntity<List<Person>> getPersonByAgeOrderAsc(@RequestParam("age") Integer age) {
        return ResponseEntity.ok(service.getPersonByAgeOrderAsc(age));
    }

    @GetMapping("/by-name-surname")
    public ResponseEntity<Optional<Person>> getPersonByNameSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return ResponseEntity.ok(service.getPersonByNameSurname(name, surname));
    }

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody PersonRequest request) {
        service.createPerson(request);
        return ResponseEntity.ok("Пользователь создан!");
    }

    @PutMapping
    public ResponseEntity<String> updatePerson(@RequestBody PersonRequest request) {
        service.updatePerson(request);
        return ResponseEntity.ok("Пользователь обновлен!");
    }

    @DeleteMapping
    public ResponseEntity<String> deletePerson(@RequestBody PersonRequest request) {
        service.deletePerson(request);
        return ResponseEntity.ok("Пользователь удалён!");
    }
}
