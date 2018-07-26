package com.inshare.blog.thymeleaf.controller;

import com.inshare.blog.thymeleaf.entity.User;
import com.inshare.blog.thymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Guichao
 * @since 2018/7/25
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getUserList(Model model) {
        model.addAttribute("userList", userService.getUserList());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    @GetMapping("/{id}")
    public ModelAndView view(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("title", "查看用户");
        return new ModelAndView("users/view", "userModel", model);
    }

    /**
     * 创建用户
     * @param model
     * @return
     */
    @GetMapping("/create")
    public ModelAndView create(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("title", "创建用户");
        return new ModelAndView("users/form", "userModel", model);
    }

    /**
     * 提交创建或保存用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView save(User user) {
        user = userService.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id, Model model) {
        userService.deleteUserById(id);
        model.addAttribute("userList", userService.getUserList());
        model.addAttribute("title", "删除用户");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 需改用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/modify/{id}")
    public ModelAndView modify(@PathVariable("id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("title", "修改用户");
        return new ModelAndView("users/form", "userModel", model);

    }
}
