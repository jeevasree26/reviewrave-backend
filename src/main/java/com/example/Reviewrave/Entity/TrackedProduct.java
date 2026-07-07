package com.example.Reviewrave.Entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tracked_products")
public class TrackedProduct {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private String category;

    private Integer totalReviews;

    @Column(name="avg_sentiment",nullable=false)
    private Double avgSentiment;

   @ManyToOne
    @JoinColumn(name="owner_id")
    private PlatformUser owner;

    @OneToMany(mappedBy = "product")
    private List<CustomerReview> reviews;

     public TrackedProduct(){

    }
    public TrackedProduct(PlatformUser owner, List<CustomerReview> reviews) {
        this.owner = owner;
        this.reviews = reviews;
    }
    
    public TrackedProduct(Long id, String name, String category, Integer totalReviews, Double avgSentiment) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.totalReviews = totalReviews;
        this.avgSentiment = avgSentiment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Double getAvgSentiment() {
        return avgSentiment;
    }

    public void setAvgSentiment(Double avgSentiment) {
        this.avgSentiment = avgSentiment;
    }

   // @OneToMany(mappedBy = "product")
    //private List<CustomerReview> reviews;

}
