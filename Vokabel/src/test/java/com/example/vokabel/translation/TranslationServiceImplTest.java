package com.example.vokabel.translation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class TranslationServiceImplTest {

    @Autowired
    TranslationService translationService;

    @Test
    void getTranslationsForGame() {
        var result = translationService.getTranslationsForGame(10, Collections.singletonList(1));

        Assert.assertNotNull(result);
    }
}
