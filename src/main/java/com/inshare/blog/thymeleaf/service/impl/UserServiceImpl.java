package com.inshare.blog.thymeleaf.service.impl;

import com.inshare.blog.thymeleaf.entity.User;
import com.inshare.blog.thymeleaf.repository.UserRepository;
import com.inshare.blog.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Guichao
 * @since 2018/7/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User saveOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getUserList() {
        return userRepository.findAll();
    }
}
