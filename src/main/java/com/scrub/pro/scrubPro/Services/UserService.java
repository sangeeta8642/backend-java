package com.scrub.pro.scrubPro.Services;

import com.scrub.pro.scrubPro.DTOs.UserDTOs.CreateUserDTO;
import com.scrub.pro.scrubPro.Models.Role;
import com.scrub.pro.scrubPro.Models.Users;
import com.scrub.pro.scrubPro.Repositories.RoleRepo;
import com.scrub.pro.scrubPro.Repositories.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(RoleRepo roleRepo, UserRepo userRepo,PasswordEncoder passwordEncoder) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.passwordEncoder=passwordEncoder;
    }

    public List<Users> getAllUsers() {
        return userRepo.findAll();
    }

    public Users getUser(int userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Users createUser(CreateUserDTO userDTO) {
        Role role = roleRepo.findById(userDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

//        if(userRepo.existingByEmail(userDTO.getEmail())){
//            return
//        }

        Users user = new Users();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());  // Correct property assignment
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(role);

        return userRepo.save(user);
    }

    public Users updateUser(int userId, CreateUserDTO userDTO) {
        Users user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role role = roleRepo.findById(userDTO.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail()); // Correct property assignment
        user.setPassword(userDTO.getPassword());
        user.setRole(role);

        return userRepo.save(user);
    }

    public boolean deleteUser(int userId) {
        if (!userRepo.existsById(userId)) {
            throw new RuntimeException("User not found");
//            return false;
        }
        userRepo.deleteById(userId);
        return true;
    }
}