package com.example.Reviewrave.Controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reviewrave.Dto.ReviewRequestDto;
import com.example.Reviewrave.Entity.CustomerReview;
import com.example.Reviewrave.Service.ReviewService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    
    private final  ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerReview submitReview(
            @Valid @RequestBody ReviewRequestDto dto) {
        return service.submitReview(dto);

    }

    @GetMapping("/product/{productId}")
    public List<CustomerReview> getReviews(
            @PathVariable Long productId) {
        return service.getReviewsByProduct(productId);
    }

    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Long id) {
        service.deleteReview(id);
        return "Review deleted successfully.";
    }
}
