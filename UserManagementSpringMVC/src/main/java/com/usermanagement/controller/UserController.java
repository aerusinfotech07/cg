package com.usermanagement.controller;

import com.usermanagement.entity.Address;
import com.usermanagement.entity.Company;
import com.usermanagement.entity.Geo;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import com.usermanagement.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        User user = new User();
        user.setAddress(new Address());
        user.getAddress().setGeo(new Geo());
        user.setCompany(new Company());
        model.addAttribute("user", user);
        return "user/form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {
        userValidator.validate(user, result);

        if (result.hasErrors()) {
            ensureNestedObjects(user);
            model.addAttribute("user", user);
            return "user/form";
        }

        if (user.getId() == null) {
            userService.save(user);
        } else {
            userService.update(user);
        }
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/users";
        }
        ensureNestedObjects(user);
        model.addAttribute("user", user);
        return "user/form";
    }

    @GetMapping("/view/{id}")
    public String viewUser(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "user/view";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    private void ensureNestedObjects(User user) {
        if (user.getAddress() == null) {
            user.setAddress(new Address());
        }
        if (user.getAddress().getGeo() == null) {
            user.getAddress().setGeo(new Geo());
        }
        if (user.getCompany() == null) {
            user.setCompany(new Company());
        }
    }
}
