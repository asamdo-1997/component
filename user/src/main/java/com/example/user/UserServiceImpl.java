package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepo;

    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public List<User> getalluser() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public Optional<User> getByNutzername(String nutzername) {
        return userRepo.findByNutzername(nutzername);
    }

    @Override
    @Transactional
    public Optional<User> getById(int id) {
        return userRepo.findById(id);
    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }


}
