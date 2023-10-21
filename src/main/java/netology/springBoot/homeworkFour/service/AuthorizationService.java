package netology.springBoot.homeworkFour.service;

import netology.springBoot.homeworkFour.exception.InvalidCredentials;
import netology.springBoot.homeworkFour.exception.UnauthorizedUser;
import netology.springBoot.homeworkFour.model.Authorities;
import netology.springBoot.homeworkFour.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {

    UserRepository userRepository;

    private AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("USER NAME OR PASSWORD IS EMPTY");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("UNKNOWN USER " + user);
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