package top.dccif.foodservice.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import top.dccif.foodservice.repository.UserRepository;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DataSourceCrud {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void testUserExample() {
        User ate = new User();
        Address ad1 = new Address();
        Address ad2 = new Address();
        ate.setUsername("test");
        ate.setNickname("my");
        ate.setGender(Gender.MALE);
        ate.setMobile("121241241");
        ate.setEmail("erwtst");
        ate.setAvatarUrl("124124");

        ad1.setDetail("123");
        ad2.setDetail("456");

        ate.getAddress().add(ad1);
        ate.getAddress().add(ad2);
        entityManager.persist(ate);
        entityManager.persist(ad1);
        entityManager.persist(ad2);
        Optional<User> userfind = userRepository.findById(1);
    }
}