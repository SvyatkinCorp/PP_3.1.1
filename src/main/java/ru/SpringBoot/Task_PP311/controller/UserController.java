package ru.SpringBoot.Task_PP311.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.SpringBoot.Task_PP311.model.User;
import ru.SpringBoot.Task_PP311.service.UserService;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.GetAllListUsers();
        model.addAttribute("allUsers", allUsers);
        return "users";
    }

    @GetMapping("users/create")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("users/create")
    public String createUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
    @GetMapping("/users/edit/{id}")
public String edit(Model model, @PathVariable int id){
        User user = userService.getUserId(id);
        model.addAttribute("user",user);
        return "edit";
    }
    @PostMapping("/users/edit/{id}")
    public String update(@ModelAttribute User user,@PathVariable int id){
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/users";
    }
    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUserId(id);
        return "redirect:/users";
    }
}
