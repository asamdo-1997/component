package com.example.vokabel.vocab;


import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.answer.AnswerResultDto;
import com.example.vokabel.translation.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("vocab")
public class VocabController {

    @Autowired
    VocabService vocabService;

    @Autowired
    TranslationService translationService;

    @PostMapping("/list/{category}")
    public void importList(@RequestParam("thumbnail") MultipartFile file, @PathVariable String category) throws IOException {
        vocabService.importList(file, category);
    }

    @GetMapping("/createGame/{category}")
    public List<Question> generateQuestions(@PathVariable String category) {
        var result = vocabService.getQuestionsForGame(category);
        return result;
    }


    @PostMapping("/checkAnswer")
    public AnswerResultDto checkAnswer(@RequestBody AnswerDto dto){
        return vocabService.checkAnswer(dto);
    }

    //todo
    @GetMapping("/getCategories")
    public List<String> getAllCategories() {
        return vocabService.getAllCategories();
    }
}
