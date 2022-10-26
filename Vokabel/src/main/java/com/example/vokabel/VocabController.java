package com.example.vokabel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("vocab")
public class VocabController {

    @Autowired
    VocabService vocabService;

    @PostMapping("/list/{category}")
    public void importList(@RequestParam("thumbnail") MultipartFile file,@PathVariable String category) throws IOException {
       vocabService.importList(file, category);
    }
}
