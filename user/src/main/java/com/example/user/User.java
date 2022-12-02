package com.example.user;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nutzerId;

    @Column
    private String nutzername;

    @Column
    private String vorname;

    @Column
    private String nachname;

    @Column
    private String email;
}
