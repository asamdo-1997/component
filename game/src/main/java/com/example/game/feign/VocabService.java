package com.example.game.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(value = "VocabService", url = "${vocab.url}/vocab")
public interface VocabService {

    @RequestMapping(method = RequestMethod.GET, value = "/createGame/{category}")
    List<Question> getQuestionsForGame(@PathVariable String category);

    /*public AnswerResultDto checkAnswer(Answer answer){
        return null;
    }*/
}
