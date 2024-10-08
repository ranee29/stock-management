package com.example.stock_management.controller;

import com.example.stock_management.dto.AuthResponseDTO;
import com.example.stock_management.dto.LoginDto;
import com.example.stock_management.dto.RegisterDto;
import com.example.stock_management.entity.Role;
import com.example.stock_management.entity.user.UserEntity;
import com.example.stock_management.repo.RoleRepository;
import com.example.stock_management.repo.user.UserRepo;
import com.example.stock_management.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private UserRepo userRepo;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;
    @Autowired
    public AuthController(AuthenticationManager authenticationManager,
                          UserRepo userRepo,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder,
                          JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }
    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterDto registerDto){
        if (userRepo.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>(registerDto, HttpStatus.BAD_REQUEST);
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registerDto.getUsername());
        userEntity.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Optional<Role> roleOpt = roleRepository.findByName("USER");
        if (roleOpt.isPresent()) {
            userEntity.setRoles(Collections.singletonList(roleOpt.get()));
        } else {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }

        userRepo.save(userEntity);
        return new ResponseEntity<>(registerDto, HttpStatus.OK);
    }
}
