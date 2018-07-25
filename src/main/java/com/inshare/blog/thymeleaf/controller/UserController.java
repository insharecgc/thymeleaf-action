package com.inshare.blog.thymeleaf.controller;

import com.inshare.blog.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guichao
 * @since 2018/7/25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getUserList(Model model) {
        model.addAttribute("userList", userService.getUserList());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("user/list", "userModel", model);
    }
}
