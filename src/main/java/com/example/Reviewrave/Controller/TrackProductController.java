package com.example.Reviewrave.Controller;

import java.util.List;

//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Reviewrave.Dto.TrackedProductDto;
import com.example.Reviewrave.Entity.TrackedProduct;
import com.example.Reviewrave.Service.TrackProductService;

import jakarta.validation.Valid;
//import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api/products")

public class TrackProductController {
    private final TrackProductService trackProductService;
    public TrackProductController(TrackProductService trackProductService){
        this.trackProductService = trackProductService;
    }
    @PostMapping
    public String createProduct(@Valid @RequestBody TrackedProductDto dto){
        return trackProductService.createProduct(dto);

    }
    @GetMapping
    public List<TrackedProduct> getAllProducts() {
        return trackProductService.getAllProducts();
    }
    @GetMapping("/{id}")
    public TrackedProduct getProduct(
            @PathVariable Long id) {
        return trackProductService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteProduct( @PathVariable Long id) {
        trackProductService.deleteProduct(id);
        return "Product deleted successfully";
    }

}
