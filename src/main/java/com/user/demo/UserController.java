package com.user.demo;


import com.user.demo.users.User;
import com.user.demo.users.UserNotFoundException;
import com.user.demo.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/users")
    public  String showUserList(Model model){
       List<User> listuser = service.listAll();
       model.addAttribute("listUser", listuser);
       return "users";

    }
    @GetMapping(value = "/user/new")
    public String showForm (Model model){
        model.addAttribute("user" , new User());
        model.addAttribute("pageTitle" , "New User");
        return "newUserForm";
    }
    @PostMapping(value = "/user/save")
    public String saveUser(User user  , RedirectAttributes ra){
        service.saveUser(user);
        ra.addFlashAttribute("message" , "addnew is successfully");
        return "redirect:/users";
    }

    @GetMapping(value = "/user/delete/{id}")
    public void deleteUser(@PathVariable("id")  int id) {
        service.deleteById(id);
    }
    @GetMapping(value = "/user/edit/{id}")
    public String  showEditForm(@PathVariable("id")  int  id , Model model ,RedirectAttributes ra){
        try{
            User user = service.get(id);
            model.addAttribute("user" , user);
            model.addAttribute("pageTitle" , "Edit user");
            return "newUserForm";

        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message" , "addnew is successfully");
            return "redirect:/users";
        }

    }



}
