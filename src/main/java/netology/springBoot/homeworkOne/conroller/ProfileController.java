package netology.springBoot.homeworkOne.conroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_3.systemProfile.SystemProfile;

@RestController
@RequestMapping("/")
public class ProfileController {
    private SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}