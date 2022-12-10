package com.example.vokabel.vocab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VocabDaoImpl implements VocabDao {

    private VocabRepo vocabRepo;

    @Autowired
    public VocabDaoImpl(VocabRepo vocabRepo) {
        this.vocabRepo = vocabRepo;
    }

    @Override
    public List<Vocab> findRandomByCategory(String category, int amount) {
        return vocabRepo.findRandomByCategory(category, amount);
    }

    @Override
    public Vocab findById(int vocabId) {
        return vocabRepo.findById(vocabId).get();
    }

    @Override
    public void save(Vocab vocab) {
        vocabRepo.save(vocab);
    }

    @Override
    public List<String> findAllCategories() {
        return vocabRepo.findAllCategories();
    }
}
