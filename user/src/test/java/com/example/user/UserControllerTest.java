package com.example.user;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class UserControllerTest {
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService() {
            @Override
            public void saveUser(User user) {
                User user1 = new User();
                user.setEmail(user.getEmail());
                user.setNachname(user.getNachname());
                user.setNutzername(user.getNutzername());
                user.setVorname(user.getVorname());
                log.info("User wurde gespeichert");
            }

            @Override
            public List<User> getalluser() {
                User user1 = new User();
                User user2 = new User();
                User user3 = new User();
                List<User> userList = List.of(user1, user2, user3);
                return userList;
            }

            @Override
            public User getByNutzername(String nutzername) {
                User user1 = new User();
                user1.setNutzername(nutzername);
                return user1;
            }

            @Override
            public User getById(int id) {
                User user = new User();
                user.setNutzerId(id);
                return user;
            }

            @Override
            public void deleteUser(int userId) {
                log.info("User" + userId + " wurde gelöscht");
            }
        };
    }
    @Test
    void saveUser() {
        User user = new User();
        user.setNutzername("jonas");
        userService.saveUser(user);
    }

    @Test
    void deleteUser() {
        userService.deleteUser(1);
    }

    @Test
    void getUserNameById() {
        int userId = 1;
        Assertions.assertEquals(userService.getById(userId).getNutzerId(), 1);
    }

    @Test
    void getallUser() {
        Assertions.assertEquals(userService.getalluser().size(), 3);
    }

    @Test
    void getUserByName() {
        String userName = "jonas";
        Assertions.assertEquals(userService.getByNutzername(userName).getNutzername(), "jonas");
    }
}