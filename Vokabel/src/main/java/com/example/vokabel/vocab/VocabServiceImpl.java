package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.translation.Translation;
import com.example.vokabel.translation.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VocabServiceImpl implements VocabService {

    @Autowired
    private VocabRepo vocabRepo;

    @Autowired
    private TranslationService translationService;

    @Value("${rounds}")
    String roundAmount;

    @Value("${perRound}")
    String perRound;

    @Value("${translations}")
    String translations;


    @Override
    public List<Question> getQuestionsForGame(String category) {

        //todo random
        var amount = Integer.parseInt(roundAmount) * Integer.parseInt(perRound);
        //List<Vocab> vocabs = vocabRepo.findAllByCategoryEqualsOOrder(category);
        List<Vocab> vocabs = vocabRepo.findRandomByCategory(category, amount);

        var translationsPerQuestions = Integer.parseInt(translations);
        var translationAmount = amount * (translationsPerQuestions - 1);
        var vocabIds = vocabs.stream().map(x -> x.getId()).collect(Collectors.toList());
        List<Translation> translations = translationService
                .getTranslationsForGame(translationAmount, vocabIds);

        var questions = new ArrayList<Question>();

        var random = new Random();
        var translationCount = 0;
        for (int i = 0; i < amount; i++) {
            var question = new Question();
            var vocab = vocabs.get(i);
            question.setVocabId(vocab.getId());
            List<Integer> translationIds = new ArrayList<>();

            var index = random.nextInt(vocab.getTranslations().size());
            translationIds.add(vocab.getTranslations().get(index).getId());

            for (int n = 0; n < translationsPerQuestions - 1; n++) {
                translationIds.add(translations.get(translationCount).getId());
                if (translationCount < translations.size()) {
                    translationCount++;
                }
            }
            Collections.shuffle(translationIds);
            question.setTranslationIds(translationIds);
            questions.add(question);
        }


        return questions;
    }

    @Override
    public boolean checkAnswer(AnswerDto dto) {
        return false;
    }

    @Override
    public List<Translation> getVocabTranslation(int vocabId) {
        return vocabRepo.findById(vocabId).get().getTranslations();
    }

    @Override
    public void addVocab(String word) {

    }

    @Override
    public void addTranslation(int vocabId) {

    }

    @Override
    public void importList(MultipartFile file, String category) throws IOException {

        List<Vocab> result = new ArrayList<>();

        String content = new String(file.getBytes());
        List<String> lines = new ArrayList<>();
        lines.addAll(Arrays.asList(content.split(System.lineSeparator())));
        lines.remove(lines.get(0));
        for (String line : lines) {
            var vocab = new Vocab();
            vocab.setCategory(category);
            List<String> words = new ArrayList<>();
            words.addAll(Arrays.asList(line.split("\\{")));

            words.remove(words.get(0));
            vocab.setName(editWord(words.get(0)));
            words.remove(words.get(0));

            List<Translation> translations = new ArrayList<>();

            for (String word : words) {
                if (word.length() > 0) {
                    var temp = new Translation();
                    temp.setName(editWord(word));
                    temp.setVocab(vocab);
                    translations.add(temp);
                }
            }
            vocab.setTranslations(translations);
            result.add(vocab);
        }
        vocabRepo.saveAll(result);
    }

    private String editWord(String word) {
        word = word.replaceAll("\\}", "");
        word = word.replaceAll(" ", "");
        word = word.replaceAll(":", "");
        return word;
    }
}
