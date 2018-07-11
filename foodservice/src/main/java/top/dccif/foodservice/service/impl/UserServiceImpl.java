package top.dccif.foodservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dccif.foodservice.domain.User;
import top.dccif.foodservice.repository.UserRepository;
import top.dccif.foodservice.service.UserService;
import top.dccif.foodservice.util.tools;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    private final
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return tools.itToList(userRepository.findAll());
    }

    @Override
    public Boolean deleteById(Integer id) {
        return userRepository.deleteUserById(id) == 1;
    }

}
