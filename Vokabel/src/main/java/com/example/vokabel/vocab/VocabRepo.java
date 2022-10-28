package com.example.vokabel.vocab;

import com.example.vokabel.vocab.Vocab;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VocabRepo extends JpaRepository<Vocab, Integer> {

    List<Vocab> findAllByCategoryEquals(String category);
}
