package com.example.Reviewrave.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Reviewrave.Entity.CustomerReview;

@Repository
public interface CustomerReviewRepository extends JpaRepository<CustomerReview, Long> {

    List<CustomerReview> findByProductId(Long productId);

    List<CustomerReview> findBySentimentScoreLessThan(Double score);
}

    
