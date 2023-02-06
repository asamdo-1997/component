package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.answer.AnswerResultDto;
import com.example.vokabel.exception.NotFoundException;
import com.example.vokabel.translation.Translation;
import com.example.vokabel.translation.TranslationDto;
import com.example.vokabel.translation.TranslationRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VocabServiceImpl implements VocabService {

    private VocabRepo vocabRepo;
    private TranslationRepo translationRepo;

    @Autowired
    public VocabServiceImpl(VocabRepo vocabRepo, TranslationRepo translationRepo) {
        this.vocabRepo = vocabRepo;
        this.translationRepo = translationRepo;
        this.translationRepo = translationRepo;
    }

    @Override
    @Transactional
    public List<Question> getQuestionsForGame(String category) {


        var amount = 9;
        List<Vocab> vocabs = vocabRepo.findRandomByCategory(category, amount);

        var translationsPerQuestions = 4;
        var translationAmount = amount * (translationsPerQuestions - 1);
        var vocabIds = vocabs.stream().map(x -> x.getId()).collect(Collectors.toList());
        List<Translation> translations = translationRepo.findRandomByLimit(translationAmount, vocabIds);

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
    @Transactional
    public List<Translation> getVocabTranslation(int vocabId) throws NotFoundException{
        var opt = vocabRepo.findById(vocabId);
        if (opt.isEmpty()){
            throw new NotFoundException("Vocab not found");
        }
        return opt.get().getTranslations();
    }


    @Override
    @Transactional
    public void importList(String content, String category) {

        List<Vocab> result = new ArrayList<>();


        List<String> lines = new ArrayList<>();
        lines.addAll(Arrays.asList(content.split(System.lineSeparator())));
        lines.remove(lines.get(0));


        for (String line : lines) {
            //StringUtils.substringBetween(line, ":");
            var parts = line.split(":");

            var vocabs = StringUtils.substringsBetween(parts[0], "{", "}");
            var translations = StringUtils.substringsBetween(parts[1], "{", "}");


            for (var vocabEntry : vocabs) {

                if (vocabEntry.length() > 0) {
                    var vocab = new Vocab();
                    vocab.setName(vocabEntry);

                    var tempTranslations = new ArrayList<Translation>();
                    for (var translationEntry : translations) {
                        if (!translationEntry.isEmpty()) {
                            var translation = new Translation();
                            translation.setVocab(vocab);
                            translation.setName(translationEntry);
                            tempTranslations.add(translation);
                        }
                    }
                    if (translations.length > 0) {
                        vocab.setTranslations(tempTranslations);
                        vocab.setCategory(category);
                        result.add(vocab);
                        System.out.println(vocab.getName());

                        vocabRepo.save(vocab);
                    }
                }
            }
        }
    }

    private String editWord(String word) {
        word = word.replaceAll("\\}", "");
        word = word.replaceAll(" ", "");
        word = word.replaceAll(":", "");
        return word;
    }

    @Override
    @Transactional
    public Vocab findVocabById(int id) throws NotFoundException{
        var opt = vocabRepo.findById(id);
        if (opt.isEmpty()){
            throw new NotFoundException("Vocab not found");
        }
        return opt.get();
    }

    @Override
    @Transactional
    public AnswerResultDto checkAnswer(AnswerDto answerDto) {

        var vocab = findVocabById(answerDto.getVocabId());
        var translations = vocab.getTranslations();

        Optional<Translation> opt = translations.stream()
                .filter(x -> x.getId() == answerDto.getTranslationId()).findFirst();
        AnswerResultDto result = new AnswerResultDto();
        result.setCorrect(opt.isPresent());
        List<TranslationDto> transDtos = new ArrayList<>();
        for (Translation translation : translations) {
            TranslationDto temp = new TranslationDto();
            temp.setId(translation.getId());
            temp.setName(translation.getName());
            transDtos.add(temp);
        }
        result.setTranslations(transDtos);
        result.setVocab(vocab.getName());
        result.setVocabId(vocab.getId());
        return result;
    }

    @Override
    @Transactional
    public List<String> getAllCategories() {
        return vocabRepo.findAllCategories();
    }

    @Override
    @Transactional
    public RoundDto mapRound(RoundDto roundDto) throws NotFoundException{
        for (var question : roundDto.getQuestions()) {
            var vocabOpt = vocabRepo.findById(question.getVocabId());
            Vocab vocab;
            if (vocabOpt.isEmpty()){
                throw new NotFoundException("Vocab not found");
            }
            else {
                vocab = vocabOpt.get();
            }
            question.setName(vocab.getName());

            for (var translation : question.getAnswers()) {
                var tempTranslation = translationRepo.findById(translation.getTranslationId()).get();
                translation.setAnswerValue(tempTranslation.getName());
            }
        }
        return roundDto;
    }
}
