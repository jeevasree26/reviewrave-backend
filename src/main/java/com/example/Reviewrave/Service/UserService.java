package com.example.Reviewrave.Service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Reviewrave.Entity.PlatformUser;
import com.example.Reviewrave.Repository.PlatformUserRepository;

@Service
public class UserService {

    private final PlatformUserRepository userRepo;

    public UserService(PlatformUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<PlatformUser> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}