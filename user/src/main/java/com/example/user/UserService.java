package com.example.user;

import java.util.List;
import java.util.Optional;

/**
*
* Das Interface für drn User.
* für die erstellung des Users
*
* @see UserServiceImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/



public interface UserService {

    /**
     * erstellt einen User
     *
     * @param user übergabe des Users
     */
    public void saveUser(User user);

    public List<User> getalluser();

    public Optional<User> getByNutzername(String nutzername);

    public Optional<User> getById(int id);



    void deleteUser(int id);
}
