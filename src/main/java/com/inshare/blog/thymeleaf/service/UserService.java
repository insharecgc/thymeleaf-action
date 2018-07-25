package com.inshare.blog.thymeleaf.service;

import com.inshare.blog.thymeleaf.entity.User;

import java.util.List;

/**
 * @author Guichao
 * @since 2018/7/25
 */
public interface UserService {

    User saveOrUpdateUser(User user);

    void deleteUserById(Integer id);

    User getUserById(Integer id);

    List<User> getUserList();
}
