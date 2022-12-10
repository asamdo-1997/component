package com.example.user;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

class UserDaoImplTest {


    private UserDaoImpl userService;

   /* @Before
    public void setUp(){
        userService = new UserDaoImpl();
    }*/

    @Test
    void createUser() {
        //Arange
        User user = new User();

        //Act
        userService.saveUser(user);

        //Assert
        Assert.notNull(user);

    }
}
