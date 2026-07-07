package com.example.Reviewrave.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Reviewrave.Entity.SentimentInsight;

@Repository
public interface SentimentInsightRepository
        extends JpaRepository<SentimentInsight, Long> {

    Optional<SentimentInsight> findByProductId(Long productId);

    @Query("SELECT s FROM SentimentInsight s")
    List<SentimentInsight> getAllInsights();
}