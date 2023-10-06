package netology.springBoot.homeworkTwo.service;

import netology.springBoot.homeworkTwo.exception.InvalidCredentials;
import netology.springBoot.homeworkTwo.exception.UnauthorizedUser;
import netology.springBoot.homeworkTwo.model.Authorities;
import netology.springBoot.homeworkTwo.repository.UserRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty"); // если присланные данные неверны
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user); //не вернул никаких разрешений, либо вернул пустую коллекцию
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}