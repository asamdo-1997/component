package com.example.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    
    void saveUser(User user);

    public List<User> getalluser();

    public Optional<User> getByNutzername(String nutzername);

    public Optional<User> getById(int id);



    void deleteUser(int userId);
}
