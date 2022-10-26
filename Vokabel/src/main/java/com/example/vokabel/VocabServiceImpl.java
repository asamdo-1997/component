package com.example.vokabel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VocabServiceImpl implements VocabService {


    @Autowired
    private VocabRepo vocabRepo;


    @Override
    public List<Integer> getVocabsForGame(int round) {
        return null;
    }

    @Override
    public boolean checkAnswer(AnswerDto dto) {
        return false;
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
        for (String line : lines){
            var vocab = new Vocab();
            vocab.setCategory(category);
            List<String> words = new ArrayList<>();
            words.addAll(Arrays.asList(line.split("\\{")));

            words.remove(words.get(0));
            vocab.setName(editWord(words.get(0)));
            words.remove(words.get(0));

            List<Translation> translations = new ArrayList<>();

            for (String word: words){
                if (word.length()>0) {
                    var temp = new Translation();
                    temp.setName(editWord(word));
                    translations.add(temp);
                }
            }
            vocab.setTranslations(translations);
           result.add(vocab);
        }
        vocabRepo.saveAll(result);
        System.out.println(result);
    }

    private String editWord(String word) {
        word = word.replaceAll("\\}", "");
        word = word.replaceAll(" ", "");
        word = word.replaceAll(":", "");
        return word;
    }
}
