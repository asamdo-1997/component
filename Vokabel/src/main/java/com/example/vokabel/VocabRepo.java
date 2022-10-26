package com.example.vokabel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabRepo extends JpaRepository<Vocab, Integer> {
}
