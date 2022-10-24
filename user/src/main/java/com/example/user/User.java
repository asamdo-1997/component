package com.example.user;
import lombok.Data;

@Data
public class User {

    private int nutzerId;
    private String nutzername;
    private String vorname;
    private String nachname;
    private String email;
}
