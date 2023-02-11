package com.example.user;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
@CrossOrigin
@Log4j2
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

    @GetMapping("/getusernamebyid/{userid}")
    public String getUserNameById(@PathVariable int userid){
        String username = userService.getById(userid).getNutzername();
        log.info(username);
        return username;
    }

    @GetMapping("/getall")
    public List<User> getallUser(){
        return userService.getalluser();
    }
    @GetMapping("/getbynutzername/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getByNutzername(name);
    }

}
