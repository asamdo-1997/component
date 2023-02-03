package com.example.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    void saveUser(User user);

    public List<User> getalluser();

    public User getByNutzername(String nutzername);

    public User getById(int id);



    void deleteUser(int userId);
}
