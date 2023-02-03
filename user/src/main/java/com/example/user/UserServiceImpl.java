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
    public User getByNutzername(String nutzername) throws NotFoundException {
        Optional<User> user = userRepo.findByNutzername(nutzername);
        if (user.isEmpty()){
            throw new NotFoundException("User not found");
        }
        return user.get();


    }

    @Override
    @Transactional
    public User getById(int id) throws NotFoundException{
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()){
            throw new NotFoundException("User not found");
        }
            return user.get();

    }

    @Override
    @Transactional
    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }


}
