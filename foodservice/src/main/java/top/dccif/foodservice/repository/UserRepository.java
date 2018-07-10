package top.dccif.foodservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import top.dccif.foodservice.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}
