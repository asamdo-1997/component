package com.example.vokabel.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationServiceImpl implements TranslationService{

    @Autowired
    private TranslationRepo translationRepo;

    @Override
    public List<Translation> getTranslationsForGame(int amount, List<Integer> notToUse){
        return translationRepo.findRandomByLimit(amount, notToUse);
    }
}
