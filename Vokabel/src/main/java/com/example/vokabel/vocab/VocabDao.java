package com.example.vokabel.vocab;

import java.util.List;

public interface VocabDao {

    List<Vocab> findRandomByCategory(String category, int amount);

    Vocab findById(int vocabId);

    void save(Vocab vocab);

    List<String> findAllCategories();
}
