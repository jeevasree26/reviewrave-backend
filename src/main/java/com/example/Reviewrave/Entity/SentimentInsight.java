package com.example.Reviewrave.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sentiment_insights")
public class SentimentInsight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private TrackedProduct product;

    @Column(columnDefinition = "TEXT")
    private String topKeywords;

    @Column(nullable = false)
    private String overallSentiment;

     public SentimentInsight(){

     }

    public SentimentInsight(Long id, TrackedProduct product, String topKeywords, String overallSentiment) {
        this.id = id;
        this.product = product;
        this.topKeywords = topKeywords;
        this.overallSentiment = overallSentiment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TrackedProduct getProduct() {
        return product;
    }

    public void setProduct(TrackedProduct product) {
        this.product = product;
    }

    public String getTopKeywords() {
        return topKeywords;
    }

    public void setTopKeywords(String topKeywords) {
        this.topKeywords = topKeywords;
    }

    public String getOverallSentiment() {
        return overallSentiment;
    }

    public void setOverallSentiment(String overallSentiment) {
        this.overallSentiment = overallSentiment;
    }

    
    
}