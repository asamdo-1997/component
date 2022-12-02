package com.example.vokabel.translation;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.answer.AnswerResultDto;
import com.example.vokabel.vocab.VocabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TranslationServiceImpl implements TranslationService{

    @Autowired
    private TranslationRepo translationRepo;

    @Autowired
    private VocabService vocabService;

    @Override
    public List<Translation> getTranslationsForGame(int amount, List<Integer> notToUse){
        return translationRepo.findRandomByLimit(amount, notToUse);
    }



}
