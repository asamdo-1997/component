package com.example.vokabel.vocab;

import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VocabRepo extends JpaRepository<Vocab, Integer> {

   // List<Vocab> findAllByCategoryEquals(String category);


    @Query(value = "select * from vocab vocab where lower(vocab.category) like lower(:category) " +
            "order by rand() limit :limit", nativeQuery = true)
    List<Vocab> findRandomByCategory(@Param("category") String category, @Param("limit") int limit);

    @Query(value = "select v.category from vocab v group by category" , nativeQuery = true)
    List<String> findAllCategories();
}
