package com.usermanagement.controller;

import com.usermanagement.entity.Address;
import com.usermanagement.entity.Company;
import com.usermanagement.entity.Geo;
import com.usermanagement.entity.User;
import com.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserViewController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @GetMapping("/new")
    public String newUserForm(Model model) {
        User user = new User();
        user.setAddress(new Address());
        user.getAddress().setGeo(new Geo());
        user.setCompany(new Company());
        model.addAttribute("user", user);
        return "userForm";
    }

    @PostMapping
    public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult result,
                           RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "userForm";
        }
        try {
            userService.createUser(user);
            redirectAttributes.addFlashAttribute("message", "User created successfully.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "userForm";
        }
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String viewUser(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<User> user = userService.getUserById(id);
        if (!user.isPresent()) {
            redirectAttributes.addFlashAttribute("error", "User not found.");
            return "redirect:/users";
        }
        model.addAttribute("user", user.get());
        return "viewUser";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<User> user = userService.getUserById(id);
        if (!user.isPresent()) {
            redirectAttributes.addFlashAttribute("error", "User not found.");
            return "redirect:/users";
        }
        model.addAttribute("user", user.get());
        return "userForm";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @Valid @ModelAttribute("user") User user,
                             BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "userForm";
        }
        try {
            userService.updateUser(id, user);
            redirectAttributes.addFlashAttribute("message", "User updated successfully.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "userForm";
        }
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            userService.deleteUser(id);
            redirectAttributes.addFlashAttribute("message", "User deleted successfully.");
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/users";
    }
}
