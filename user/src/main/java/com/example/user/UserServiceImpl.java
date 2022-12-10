package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public List<User> getalluser() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> getByNutzername(String nutzername) {
        return userDao.findByNutzername(nutzername);
    }

    @Override
    public Optional<User> getById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }


}
