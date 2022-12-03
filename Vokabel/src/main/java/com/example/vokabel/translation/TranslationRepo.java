package com.example.vokabel.translation;

import com.example.vokabel.translation.Translation;
import com.example.vokabel.vocab.Vocab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TranslationRepo extends JpaRepository<Translation, Integer> {

    @Query(value = "select * from translation t " +
            "where t.vocab_id not in :ids " +
            "order by rand() limit :limit", nativeQuery = true)
    List<Translation> findRandomByLimit(@Param("limit") int limit, @Param("ids") List<Integer> ids);
}
