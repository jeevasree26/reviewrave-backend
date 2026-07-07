package com.example.Reviewrave.Dto;


public class InsightResponseDto {

    private Long productId;

    private String topKeywords;

    private String overallSentiment;

     public InsightResponseDto(){

     }

    public InsightResponseDto(Long productId, String topKeywords, String overallSentiment) {
        this.productId = productId;
        this.topKeywords = topKeywords;
        this.overallSentiment = overallSentiment;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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