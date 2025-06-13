package com.scrub.pro.scrubPro.Controllers;


//import com.crud.users.DTOs.LoginDTO;
//import com.crud.users.Security.JwtUtil;
//import com.crud.users.Services.CustomUserDetailsService;

import com.scrub.pro.scrubPro.DTOs.AuthDTOs.CheckEmailReqDTO;
import com.scrub.pro.scrubPro.DTOs.AuthDTOs.FirstTimeLoginReqDTO;
import com.scrub.pro.scrubPro.DTOs.AuthDTOs.LoginDTO;
import com.scrub.pro.scrubPro.DTOs.UserDTOs.CreateUserDTO;
import com.scrub.pro.scrubPro.Models.Users;
import com.scrub.pro.scrubPro.Repositories.StaggedUserRepo;
import com.scrub.pro.scrubPro.Repositories.UserRepo;
import com.scrub.pro.scrubPro.Security.JwtUtil;
import com.scrub.pro.scrubPro.Services.CustomUserDetailsService;
import com.scrub.pro.scrubPro.Services.UserService;
import io.jsonwebtoken.security.Password;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    private final UserRepo userRepo;
    private final StaggedUserRepo staggedUserRepo;

    private final UserService userService;

    public AuthController(AuthenticationManager authManager,
                          JwtUtil jwtUtil,
                          CustomUserDetailsService userDetailsService,
                          StaggedUserRepo staggedUserRepo,
                          UserRepo userRepo,
                          PasswordEncoder passwordEncoder,
                          UserService userService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.staggedUserRepo = staggedUserRepo;
        this.userRepo = userRepo;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto) {
        System.out.println("email "+dto.getEmail()+" password "+dto.getPassword()+" matched "+passwordEncoder.matches(dto.getPassword(),"$2a$10$XNDySpBZswmxWdbGQqz8qOA.bFfgdun7qkXnQI22s1Kq4hwIQcSpi"));

        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

            Users user = userRepo.findByEmail(dto.getEmail()).orElse(null);

            final String token = jwtUtil.generateToken(dto.getEmail());
            return ResponseEntity.ok().body(Map.of("token", token,"message","Login Successful","success",true,"user",user));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }
    }

    @PostMapping("/check-email")
    public ResponseEntity<?> checkEmail(@RequestBody CheckEmailReqDTO request) {
        String email = request.getEmail();

        boolean isStagged = staggedUserRepo.existingByEmail(email);
        boolean isActual = userRepo.existingByEmail(email);

        System.out.println("isStagged "+isStagged+" isActual "+isActual);

        if (!isActual && isStagged) {
            return ResponseEntity.ok(Map.of("status", "first_time"));
        } else if (isActual) {
            return ResponseEntity.ok(Map.of("status", "existing"));
        } else {
            return ResponseEntity.ok(Map.of("error", "Email not found"));
        }
    }

    @PostMapping("/first-time-login")
    public ResponseEntity<?> firstTimeLogin(@RequestBody FirstTimeLoginReqDTO request) {
        return staggedUserRepo.findByEmail(request.getEmail()).map(staggedUser -> {
            System.out.println("staggedUser.getPassword() "+staggedUser.getPassword()+" request.getDefaultPassword() "+request.getDefaultPassword()+" request.newPassword() "+request.getNewPassword());
            if (passwordEncoder.matches(request.getDefaultPassword(), staggedUser.getPassword())) {

                CreateUserDTO user = new CreateUserDTO();

                user.setEmail(request.getEmail());
                user.setPassword(request.getNewPassword());
                user.setUserName(staggedUser.getUserName());
                user.setRoleId(staggedUser.getRole().getTitle());

//               userRepo.save(user);
                userService.createUser(user);

                final String token = jwtUtil.generateToken(user.getEmail());
//                return ResponseEntity.ok().body(Map.of("token", token));

                return ResponseEntity.ok(Map.of("message", "User created successfully","token",token,"user",user));
            } else {
                return ResponseEntity.status(401).body(Map.of("error", "Invalid Password"));
            }
        }).orElseGet(() -> ResponseEntity.status(401).body(Map.of("error", "User not found in stagged table")));
    }
}

