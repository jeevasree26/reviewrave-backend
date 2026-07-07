package com.example.Reviewrave.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Reviewrave.Entity.TrackedProduct;

public interface TrackedProductRepository extends JpaRepository<TrackedProduct,Long> {
    
List<TrackedProduct> findByCategory(String category);
Optional<TrackedProduct> findByName(String name);
boolean existsByName(String name);

}
