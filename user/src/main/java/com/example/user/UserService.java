package com.example.user;

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

    void deleteUser(int id);
}
