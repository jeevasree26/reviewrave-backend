package com.example.Reviewrave.Service;


import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reviewrave.Entity.CustomerReview;
import com.example.Reviewrave.Entity.SentimentInsight;
import com.example.Reviewrave.Entity.TrackedProduct;
import com.example.Reviewrave.Repository.CustomerReviewRepository;
import com.example.Reviewrave.Repository.SentimentInsightRepository;
import com.example.Reviewrave.Repository.TrackedProductRepository;
@Service
public class InsightService {

    private final SentimentInsightRepository insightRepo;
    private final  TrackedProductRepository productRepo;
    public InsightService(SentimentInsightRepository insightRepo, TrackedProductRepository productRepo,
            CustomerReviewRepository reviewRepo) {
        this.insightRepo = insightRepo;
        this.productRepo = productRepo;
        this.reviewRepo = reviewRepo;
    }

    private  final CustomerReviewRepository reviewRepo;

    public SentimentInsight generateInsights(Long productId) {

        TrackedProduct product = productRepo.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        List<CustomerReview> reviews =
                reviewRepo.findByProductId(productId);

        String overallSentiment = "NEUTRAL";

        double avg = reviews.stream()
                .mapToDouble(CustomerReview::getSentimentScore)
                .average()
                .orElse(0);

        if (avg > 0.7) {
            overallSentiment = "POSITIVE";
        } else if (avg < 0.4) {
            overallSentiment = "NEGATIVE";
        }

        SentimentInsight insight = new SentimentInsight();

        insight.setProduct(product);
        insight.setTopKeywords("quality,service");
        insight.setOverallSentiment(overallSentiment);

        return insightRepo.save(insight);
    }

    public SentimentInsight getInsights(Long productId) {

        return insightRepo.findByProductId(productId)
                .orElseThrow(() ->
                        new RuntimeException("Insight not found"));
    }
}