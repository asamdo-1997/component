package com.example.vokabel.vocab;

import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.answer.AnswerResultDto;
import com.example.vokabel.translation.Translation;
import com.example.vokabel.translation.TranslationDto;
import com.example.vokabel.translation.TranslationRepo;
import com.example.vokabel.translation.TranslationDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class VocabServiceImpl implements VocabService {

    private VocabDao vocabDao;
    private TranslationDao translationDao;
    private TranslationRepo translationRepo;

    @Value("${rounds}")
    String roundAmount;

    @Value("${perRound}")
    String perRound;

    @Value("${translations}")
    String translations;

    @Autowired
    public VocabServiceImpl(VocabDao vocabDao, TranslationDao translationDao, TranslationRepo translationRepo) {
        this.vocabDao = vocabDao;
        this.translationDao = translationDao;
        this.translationRepo = translationRepo;
    }

    @Override
    public List<Question> getQuestionsForGame(String category) {


        var amount = Integer.parseInt(roundAmount) * Integer.parseInt(perRound);
        //List<Vocab> vocabs = vocabRepo.findAllByCategoryEqualsOOrder(category);
        List<Vocab> vocabs = vocabDao.findRandomByCategory(category, amount);

        var translationsPerQuestions = Integer.parseInt(translations);
        var translationAmount = amount * (translationsPerQuestions - 1);
        var vocabIds = vocabs.stream().map(x -> x.getId()).collect(Collectors.toList());
        List<Translation> translations = translationDao
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
    public List<Translation> getVocabTranslation(int vocabId) {
        return vocabDao.findById(vocabId).getTranslations();
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
            //StringUtils.substringBetween(line, ":");
            var parts = line.split(":");

            var vocabs = StringUtils.substringsBetween(parts[0], "{", "}");
            var translations = StringUtils.substringsBetween(parts[1], "{", "}");


            for (var vocabEntry : vocabs) {

                if (vocabEntry.length()>0) {
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
                        vocabDao.save(vocab);
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
    public Vocab findVocabById(int id) {
        return vocabDao.findById(id);
    }

    @Override
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
    public List<String> getAllCategories() {
        return vocabDao.findAllCategories();
    }

    @Override
    public RoundDto mapRound(RoundDto roundDto){
        for (var question : roundDto.getQuestions()){
            var vocab = vocabDao.findById(question.getVocabId());
            question.setName(vocab.getName());

            for (var translation : question.getAnswers()){
                var tempTranslation = translationRepo.findById(translation.getTranslationId()).get();
                translation.setAnswerValue(tempTranslation.getName());
            }
        }
        return roundDto;
    }
}
