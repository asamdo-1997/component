package com.example.vokabel.translation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

class TranslationDaoImplTest {

    @Autowired
    TranslationDao translationDao;

    @Test
    void getTranslationsForGame() {
        var result = translationDao.getTranslationsForGame(10, Collections.singletonList(1));

        Assert.assertNotNull(result);
    }
}
