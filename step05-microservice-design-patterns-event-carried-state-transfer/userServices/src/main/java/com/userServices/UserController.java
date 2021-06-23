package com.userServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    private UserService userService;
    
    
    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
    
    @PostMapping("/create")
    public Long createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }
    
    @PutMapping("/update")
    public void updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
    }
}
