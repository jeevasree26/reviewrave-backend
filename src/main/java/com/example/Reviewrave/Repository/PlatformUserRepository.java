package com.example.Reviewrave.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Reviewrave.Entity.PlatformUser;

@Repository
public interface PlatformUserRepository
        extends JpaRepository<PlatformUser, Long> {

    Optional<PlatformUser> findByEmail(String email);

    boolean existsByEmail(String email);
}