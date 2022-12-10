package com.example.user;

import java.util.List;
import java.util.Optional;

/**
*
* Das Interface für drn User.
* für die erstellung des Users
*
* @see UserDaoImpl
* @author Dominik Asam, Ataullah Shinwari, Jonas Jacobsen
*
* @version 1.0
*/



public interface UserDao {

    /**
     * erstellt einen User
     *
     * @param user übergabe des Users
     */
    public void saveUser(User user);

    void deleteUser(int id);

    List<User> findAll();

    Optional<User> findByNutzername(String nutzername);

    Optional<User> findById(int id);
}
