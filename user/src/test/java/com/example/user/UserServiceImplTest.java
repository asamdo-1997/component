package com.example.user;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {


    private UserServiceImpl userService;

    @Before
    public void setUp(){
        userService = new UserServiceImpl();
    }

    @Test
    void createUser() {
        //Arange
        User user = new User();

        //Act
        userService.createUser(user);

        //Assert
        Assert.notNull(user);

    }
}
