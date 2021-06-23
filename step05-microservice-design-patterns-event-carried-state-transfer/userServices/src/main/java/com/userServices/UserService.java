package com.userServices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface UserService {
    public List<User> getAllUser();
    public Long createUser(UserDto userDto);
    public void updateUser(UserDto userDto);
}

@Service
class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Long createUser(UserDto userDto) {
        User user = new User();
        
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        
        return userRepository.save(user).getId();
    }

    @Transactional
    public void updateUser(UserDto userDto) {
        userRepository.findById(userDto.getId())
        .ifPresent(user -> {
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setEmail(userDto.getEmail());
            
            this.raiseEvent(userDto);
        });
    }

    
    private void raiseEvent(UserDto userDto) {
        System.out.println("raise event");
    }

}
