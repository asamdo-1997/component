package com.example.game.feign;

import com.example.game.answer.AnswerDto;
import com.example.game.answer.AnswerResultDto;
import com.example.game.exception.FeignConfig;
import com.example.game.round.Question;
import com.example.game.round.RoundDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(value = "VocabService", url = "${vocab.url}/vocab",
    configuration = FeignConfig.class)
public interface VocabService {

    @RequestMapping(method = RequestMethod.GET, value = "/createGame/{category}")
    List<Question> getQuestionsForGame(@PathVariable(value = "category")  String category);

    @RequestMapping(method = RequestMethod.POST, value = "/checkAnswer")
    AnswerResultDto checkAnswer(@RequestBody AnswerDto input);

    @RequestMapping(method = RequestMethod.POST, value = "/mapRound")
    RoundDto mapQuestion(@RequestBody RoundDto roundDto);
}
