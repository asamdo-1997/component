package com.example.vokabel.answer;

import com.example.vokabel.translation.Translation;
import com.example.vokabel.translation.TranslationDto;
import com.example.vokabel.vocab.VocabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    VocabService vocabService;

    @Override
    public AnswerResultDto checkAnswer(AnswerDto answerDto) {
        var translations = vocabService.getVocabTranslation(answerDto.getVocabId());

        Optional<Translation> opt = translations.stream()
                .filter(x -> x.getId() == answerDto.getTranslationId()).findFirst();
        AnswerResultDto result = new AnswerResultDto();
        result.setRight(opt.isPresent());
        List<TranslationDto> transDtos = new ArrayList<>();
        for (Translation translation: translations){
            TranslationDto temp = new TranslationDto();
            temp.setId(translation.getId());
            temp.setName(translation.getName());
            transDtos.add(temp);
        }
        result.setTranslations(transDtos);
        return result;
    }
}
