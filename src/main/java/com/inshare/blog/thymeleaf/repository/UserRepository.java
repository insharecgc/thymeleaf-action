package com.inshare.blog.thymeleaf.repository;

import com.inshare.blog.thymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Guichao
 * @since 2018/7/25
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
