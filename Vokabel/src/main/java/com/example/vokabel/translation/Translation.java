package com.example.vokabel.translation;

import com.example.vokabel.vocab.Vocab;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Vocab vocab;

    @Version
    private Integer version;
}
