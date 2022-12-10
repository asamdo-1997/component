package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getalluser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getByNutzername(String nutzername) {
        return userRepository.findByNutzername(nutzername);
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


}
