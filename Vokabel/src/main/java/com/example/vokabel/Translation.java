package com.example.vokabel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "vocabId")
    private Vocab vocab;
}
