package top.dccif.foodservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.dccif.foodservice.domain.User;
import top.dccif.foodservice.service.UserService;

@RestController
public class UserController {
    private final
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findBy/username/{username}")
    public User getUserByUserName(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }
}
