package com.example.Reviewrave.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.example.Reviewrave.Controller.AccountController;
import com.example.Reviewrave.Entity.AccountEntity;
import java.util.Optional;


public interface AccountRepo extends JpaRepository<AccountEntity,Long>{


    Optional<AccountEntity> findByEmail(String email);
    boolean existsByEmail(String email);
} 



    
