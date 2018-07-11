package top.dccif.foodservice.service;

import top.dccif.foodservice.domain.User;

import java.util.List;

public interface UserService {


    /**
     * 根据表单保存用户信息
     *
     * @param user 用户模型
     * @return 保存的用户
     */
    User save(User user);

    /**
     * 根据提交更新用户信息
     *
     * @param user 用户信息
     * @return 更新后的用户信息
     */
    User updateUser(User user);

    /**
     * 根据用户名查找用户
     *
     * @param username 用户名字符串
     * @return 用户Dao
     */
    User findByUsername(String username);

    /**
     * 查看系统中所有用户
     *
     * @return 用户列表
     */
    List<User> findAll();

    Boolean deleteById(Integer id);
}
