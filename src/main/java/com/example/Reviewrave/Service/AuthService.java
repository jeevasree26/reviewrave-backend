package com.example.Reviewrave.Service;

//import org.hibernate.engine.jndi.spi.JndiService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Reviewrave.Dto.LoginRequestDto;
import com.example.Reviewrave.Dto.RegisterUserDto;
import com.example.Reviewrave.Entity.AccountEntity;
import com.example.Reviewrave.Repository.AccountRepo;
import com.example.Reviewrave.Security.JwtService;

@Service
public class AuthService {

   private final JwtService jwtService;
    private  final AccountRepo repo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(JwtService jwtService, AccountRepo repo, PasswordEncoder passwordEncoder) {
    this.jwtService = jwtService;
    this.repo = repo;
    this.passwordEncoder = passwordEncoder;
}

    public String registerUser(RegisterUserDto dto) {

        if (repo.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        AccountEntity account = new AccountEntity();

        account.setEmail(dto.getEmail());
        account.setPassword(
                passwordEncoder.encode(dto.getPassword())
        );
        account.setRole(dto.getRole());
        account.setActive(true);

        repo.save(account);

        return "User Registered Successfully";
    }
    public String login(LoginRequestDto dto) {
        AccountEntity acc = repo.findByEmail(dto.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
        if (!passwordEncoder.matches(
                dto.getPassword(),
                acc.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }
      return jwtService.generateToken(acc);
    }
}