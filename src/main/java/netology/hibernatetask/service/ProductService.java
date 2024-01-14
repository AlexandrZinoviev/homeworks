package netology.hibernatetask.service;

import netology.hibernatetask.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final OrderRepository repository;

    public ProductService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<String> getProduct(String productName) {
        return repository.getProduct(productName);
    }
}