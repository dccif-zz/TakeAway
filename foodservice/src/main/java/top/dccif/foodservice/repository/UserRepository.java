package top.dccif.foodservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import top.dccif.foodservice.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

    @Transactional
    Integer deleteUserById(Integer id);

    User save(User user);

    User findByUsername(String username);

    @Override
    Iterable<User> findAll();
}
