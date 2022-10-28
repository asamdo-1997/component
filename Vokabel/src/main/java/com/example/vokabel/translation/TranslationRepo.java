package com.example.vokabel.translation;

import com.example.vokabel.translation.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepo extends JpaRepository<Translation, Integer> {
}
