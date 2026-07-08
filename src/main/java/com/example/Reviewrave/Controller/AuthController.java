package com.example.Reviewrave.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Reviewrave.Dto.LoginRequestDto;
import com.example.Reviewrave.Dto.RegisterUserDto;
import com.example.Reviewrave.Service.AuthService;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private  final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/index")
    public String login(@RequestBody LoginRequestDto dto) {
        return authService.login(dto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(
    @RequestBody RegisterUserDto dto) {
    System.out.println("EMAIL = " + dto.getEmail());
    System.out.println("PASSWORD = " + dto.getPassword());
    System.out.println("ROLE = " + dto.getRole());

    return ResponseEntity.ok(authService.registerUser(dto));
}
}





