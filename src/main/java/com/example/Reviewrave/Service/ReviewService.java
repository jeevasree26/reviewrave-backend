package com.example.Reviewrave.Service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reviewrave.Dto.ReviewRequestDto;
import com.example.Reviewrave.Entity.CustomerReview;
import com.example.Reviewrave.Entity.TrackedProduct;
import com.example.Reviewrave.Repository.TrackedProductRepository;
import com.example.Reviewrave.Repository.CustomerReviewRepository;
@Service
public class ReviewService {
    

private  final TrackedProductRepository productRepo;
private final CustomerReviewRepository reviewRepo;

     public ReviewService(TrackedProductRepository productRepo, CustomerReviewRepository reviewRepo) {
    this.productRepo = productRepo;
    this.reviewRepo = reviewRepo;
}
     public CustomerReview submitReview(ReviewRequestDto dto) {

                TrackedProduct product = productRepo.findById(dto.getProductId())
        .orElseThrow(() -> new RuntimeException("Product not found"));

        CustomerReview review = new CustomerReview();

        review.setProduct(product);
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());

        // Temporary sentiment score
        review.setSentimentScore(0.8);

        return reviewRepo.save(review);
    }
    public List<CustomerReview> getReviewsByProduct(Long productId) {
        return reviewRepo.findByProductId(productId);
    }
    public void deleteReview(Long id) {
        if (!reviewRepo.existsById(id)) {
            throw new RuntimeException("Review not found");
        }

        reviewRepo.deleteById(id);
    }
}
