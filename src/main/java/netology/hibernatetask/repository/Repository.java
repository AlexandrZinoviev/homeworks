package netology.hibernatetask.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import netology.hibernatetask.Person;

import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager manager;

    public List<Person> getByCity(String city) {
        return manager.createQuery("SELECT p FROM PersonsCard p WHERE p.cityOfLiving = :city")
                .setParameter("name", city).getResultList();
    }
}