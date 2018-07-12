package top.dccif.foodservice.controller;

import org.springframework.web.bind.annotation.*;
import top.dccif.foodservice.domain.Address;
import top.dccif.foodservice.domain.User;
import top.dccif.foodservice.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
public class AdminController {
    private final
    UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAllUser")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/addUser")
    public User save(User user) {
        Set<Address> sed = user.getAddress();
        return userService.save(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public Boolean deleteById(@PathVariable("id") Integer id) {
        return userService.deleteById(id);
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}