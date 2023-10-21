package netology.springBoot.homeworkThree.service;

import netology.springBoot.homeworkThree.exceptions.InvalidCredentials;
import netology.springBoot.homeworkThree.exceptions.UnauthorizedUser;
import netology.springBoot.homeworkThree.repository.Authorities;
import netology.springBoot.homeworkThree.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import netology.springBoot.homeworkThree.repository.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationService {

    private final UserRepository userRepository;

    private AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {

        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
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