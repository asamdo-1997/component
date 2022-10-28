package com.example.vokabel.translation;

import java.util.List;

public interface TranslationService {
    List<Translation> getTranslationsForGame(int amount, List<Integer> notToUse);
}
