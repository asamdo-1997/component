package com.example.vokabel.translation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepo extends JpaRepository<Translation, Integer> {



    @Query(value = "select * from translation t " +
            "where t.vocab_id not in :ids " +
            "order by rand() limit :limit", nativeQuery = true)
    List<Translation> findRandomByLimit(@Param("limit") int limit, @Param("ids") List<Integer> ids);
}
