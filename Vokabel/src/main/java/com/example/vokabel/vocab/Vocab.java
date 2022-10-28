package com.example.vokabel.vocab;

import com.example.vokabel.translation.Translation;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Vocab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vocab")
    private List<Translation> translations;

    @Column
    private String category;

    //
}
