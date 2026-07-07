package com.example.Reviewrave.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ReviewRequestDto {
    private Long productId;

    @Size(min = 5, max = 1000)
    private String content;

    @Min(1)
    @Max(5)
    private Integer rating;

    public ReviewRequestDto(){

    }

    public ReviewRequestDto(Long productId, @Size(min = 5, max = 1000) String content, @Min(1) @Max(5) Integer rating) {
        this.productId = productId;
        this.content = content;
        this.rating = rating;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
 

    

}
