package com.example.Reviewrave.Service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Reviewrave.Dto.TrackedProductDto;
import com.example.Reviewrave.Entity.TrackedProduct;
import com.example.Reviewrave.Repository.TrackedProductRepository;

@Service
public class TrackProductService {

    private  final TrackedProductRepository repo;

    public TrackProductService(TrackedProductRepository repo) {
        this.repo = repo;
    }

    public String createProduct(TrackedProductDto dto) {

        TrackedProduct product = new TrackedProduct(
                null,
                dto.name,
                dto.category,
                0,
                0.0
        );

        repo.save(product);

        return "Product Created Successfully";
    }

    public List<TrackedProduct> getAllProducts() {
        return repo.findAll();
    }

    public TrackedProduct getProductById(Long id) {

        return repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product Not Found"));
    }

    public String deleteProduct(Long id) {

        repo.deleteById(id);

        return "Product Deleted Successfully";
    }
}
