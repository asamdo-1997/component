package com.example.vokabel.vocab;


import com.example.vokabel.answer.AnswerDto;
import com.example.vokabel.answer.AnswerResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("vocab")
public class VocabController {

    VocabService vocabService;

    @Autowired
    public VocabController(VocabService vocabService) {
        this.vocabService = vocabService;
    }

    @PostMapping("/list/{category}")
    public void importList(@RequestParam("thumbnail") MultipartFile file, @PathVariable String category) throws IOException {
        String content = new String(file.getBytes());
        vocabService.importList(content, category);
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

    @PostMapping("/mapRound")
    public RoundDto mapRound(@RequestBody RoundDto dto){
        return vocabService.mapRound(dto);

    }
}
