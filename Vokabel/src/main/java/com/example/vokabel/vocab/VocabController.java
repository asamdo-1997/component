package com.example.vokabel.vocab;


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

    @PostMapping("/list/{category}")
    public void importList(@RequestParam("thumbnail") MultipartFile file, @PathVariable String category) throws IOException {
        vocabService.importList(file, category);
    }

    @GetMapping("/createGame/{category}")
    public List<Question> generateQuestions(@PathVariable String category) {
        var result = vocabService.getQuestionsForGame(category);
        return result;
    }


    //todo
    @GetMapping("/getCategories")
    public List<String> getAllCategories() {
        return null;
    }
}
